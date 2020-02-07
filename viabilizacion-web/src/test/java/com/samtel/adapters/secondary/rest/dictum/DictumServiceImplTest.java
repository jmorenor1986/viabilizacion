package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.dto.ResponseDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.config.ClientesProperties;
import com.samtel.domain.solicitud.RequestDictum;
import com.samtel.domain.solicitud.ResponseDictum;
import com.samtel.ports.secondary.solicitud.DictumService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DictumServiceImplTest {
    private DictumService dictumService;
    private ClientesProperties properties;
    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";
    public static final String INPUT = "<Informe fechaConsulta=\"2020-01-22T08:36:55\" respuesta=\"13\" codSeguridad=\"WFN72G4\" tipoIdDigitado=\"1\" identificacionDigitada=\"91518562\" apellidoDigitado=\"BECERRA\">\n" +
            "   <NaturalNacional nombres=\"YEHISON FABIAN\" primerApellido=\"BECERRA\" segundoApellido=\"RODRIGUEZ\" nombreCompleto=\"BECERRA RODRIGUEZ YEHISON FABIAN\" validada=\"true\" rut=\"true\" genero=\"4\">\n" +
            "      <Identificacion estado=\"00\" fechaExpedicion=\"2001-05-07\" ciudad=\"BUCARAMANGA\" departamento=\"SANTANDER\" genero=\"4\" numero=\"00091518562\"/>\n" +
            "      <Edad min=\"36\" max=\"45\"/>\n" +
            "      <InfoDemografica/>\n" +
            "   </NaturalNacional>\n" +
            "</Informe>";
    public static final String OUTPUT = "{\"Informe\":{\"fechaConsulta\":\"2020-01-22T08:36:55\",\"tipoIdDigitado\":1,\"identificacionDigitada\":91518562,\"apellidoDigitado\":\"BECERRA\",\"respuesta\":13,\"codSeguridad\":\"WFN72G4\",\"NaturalNacional\":{\"rut\":true,\"Edad\":{\"min\":36,\"max\":45},\"Identificacion\":{\"fechaExpedicion\":\"2001-05-07\",\"estado\":\"00\",\"numero\":\"00091518562\",\"ciudad\":\"BUCARAMANGA\",\"genero\":4,\"departamento\":\"SANTANDER\"},\"primerApellido\":\"BECERRA\",\"genero\":4,\"segundoApellido\":\"RODRIGUEZ\",\"validada\":true,\"nombreCompleto\":\"BECERRA RODRIGUEZ YEHISON FABIAN\",\"nombres\":\"YEHISON FABIAN\",\"InfoDemografica\":\"\"}}}";

    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private DictumXMLMapper dictumXMLMapper;
    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriDictum(URI);
        dictumService = new DictumServiceImpl(restTemplateService, properties, dictumXMLMapper, modelMapper);
    }

    @Test
    public void testDictumSuccess() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        ResponseDictum responseDictum = Mockito.mock(ResponseDictum.class);
        response.setRespuestaServicio(INPUT);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(modelMapper.map(response, ResponseDictum.class)).thenReturn(responseDictum);
        Mockito.when(dictumXMLMapper.toJsonString(INPUT)).thenReturn(Optional.of(OUTPUT));
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO)).thenReturn(Optional.of(response));
        Optional<ResponseDictum> result = dictumService.consultarDictum(request);
        Assert.assertNotNull(result);
    }
}
