package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.secondary.rest.MockGenericRequestClient;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.ports.secondary.solicitud.DictumService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private DictumMapperImpl dictumMapper;
    private Dictum dictum;
    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";
    @Mock
    private RestTemplateService restTemplateService;


    private Map<String, String> headers;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriDictum(URI);
        dictumMapper = new DictumMapperImpl();
        dictumService = new DictumServiceImpl(restTemplateService, properties, dictumMapper);
        headers = new HashMap<>();
        headers.put("idRequest", "1");
        headers.put("idCache", "{}");
        dictum = Dictum.builder()
                .clave("1234567")
                .parametros(new ArrayList<>())
                .primerApellido("moreno")
                .producto("12345")
                .usuario("usuario")
                .build();
    }

    @Test
    public void testDictumSuccessPREAPROBADO_CON_DOCUMENTOS() {
        Mockito.when(restTemplateService.postWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of("PREAPROBADO_CON_DOCUMENTOS"));
        Optional<String> result = dictumService.consultarSolicitudDictum(MockGenericRequestClient.setClient(), dictum, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_PREAPROBADO_CON_DOCUMENTOS);
    }

    @Test
    public void testDictumSuccessAPROBADO() {
        Mockito.when(restTemplateService.postWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(MockResponseDictumTest.APROBADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(MockGenericRequestClient.setClient(), dictum, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_APROBADO);
    }

    @Test
    public void testDictumSuccessNEGADO() {
        Mockito.when(restTemplateService.postWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(MockResponseDictumTest.NEGADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(MockGenericRequestClient.setClient(), dictum, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_NEGADO);
    }
}
