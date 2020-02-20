package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.dto.ResponseDictumDTO;
import com.samtel.domain.solicitud.dictum.RequestDictum;
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
    public static final String RESPUESTA_APROBADO = "APROBADO";
    public static final String RESPUESTA_NEGADO = "NEGADO";
    public static final String RESPUESTA_PREAPROBADO_SIN_DOCUMENTOS = "PREAPROBADO_SIN_DOCUMENTOS";
    public static final String RESPUESTA_PREAPROBADO_CON_DOCUMENTOS = "PREAPROBADO_CON_DOCUMENTOS";
    public static final String RESPUESTA_ERROR_EN_PROCESO = "ERROR EN PROCESO";
    private DictumService dictumService;
    private ClientesProperties properties;
    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";

    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriDictum(URI);
        dictumService = new DictumServiceImpl(restTemplateService, properties, modelMapper);
    }

    @Test
    public void testDictumSuccessAPROBADO() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        response.setRespuestaServicio(MockResponseDictumTest.APROBADO);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO, Optional.of("123"))).thenReturn(Optional.of(MockResponseDictumTest.APROBADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(request,"123");
        Assert.assertEquals(result.get(), RESPUESTA_APROBADO);
    }

    @Test
    public void testDictumSuccessNEGADO() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        response.setRespuestaServicio(MockResponseDictumTest.NEGADO);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO,Optional.of("123"))).thenReturn(Optional.of(MockResponseDictumTest.NEGADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, "123");
        Assert.assertEquals(result.get(), RESPUESTA_NEGADO);
    }

    @Test
    public void testDictumSuccessPREAPROBADO_SIN_DOCUMENTOS() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        response.setRespuestaServicio(MockResponseDictumTest.PREAPROBADO_SIN_DOCUMENTOS);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO, Optional.of("123"))).thenReturn(Optional.of(MockResponseDictumTest.PREAPROBADO_SIN_DOCUMENTOS));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, "123");
        Assert.assertEquals(result.get(), RESPUESTA_PREAPROBADO_SIN_DOCUMENTOS);
    }

    @Test
    public void testDictumSuccessPREAPROBADO_CON_DOCUMENTOS() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        response.setRespuestaServicio(MockResponseDictumTest.PREAPROBADO_CON_DOCUMENTOS);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO, Optional.of("123"))).thenReturn(Optional.of(MockResponseDictumTest.PREAPROBADO_CON_DOCUMENTOS));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, "123");
        Assert.assertEquals(result.get(), RESPUESTA_PREAPROBADO_CON_DOCUMENTOS);
    }

    @Test
    public void testDictumSuccessERROR_EN_PROCESO() {
        RequestDictum request = Mockito.mock(RequestDictum.class);
        RequestDictumDTO requestDictumDTO = Mockito.mock(RequestDictumDTO.class);
        ResponseDictumDTO response = new ResponseDictumDTO();
        response.setRespuestaServicio(MockResponseDictumTest.ERROR_EN_PROCESO);
        Mockito.when(modelMapper.map(request, RequestDictumDTO.class)).thenReturn(requestDictumDTO);
        Mockito.when(restTemplateService.getWithOutParams(properties.getUriDictum(), requestDictumDTO , Optional.of("123"))).thenReturn(Optional.of(MockResponseDictumTest.ERROR_EN_PROCESO));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, "123");
        Assert.assertEquals(result.get(), RESPUESTA_ERROR_EN_PROCESO);
    }

}
