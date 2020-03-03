package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestBodyDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestHeaderDTO;
import co.com.santander.core.domain.solicitud.dictum.Parametros;
import co.com.santander.core.domain.solicitud.dictum.RequestBody;
import co.com.santander.core.domain.solicitud.dictum.RequestDictum;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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
    private RequestDictum request;
    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private ModelMapper modelMapper;
    private RequestHeader requestHeader;
    private RequestBody requestBody;

    private Map<String, String> headers;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        requestHeader = new RequestHeader();
        requestHeader.setCodAliado("001");
        requestHeader.setUsuarioAliado("pepito.perez@sanitas.com.co");
        requestHeader.setIdentificacion("91518562");
        requestHeader.setTipoIdentificacion("1");
        requestHeader.setIpOrigen("127.0.0.1");
        requestHeader.setNumeroSolicitudCredito("00012");
        requestHeader.setSesionId("fb2e77d.47a0479900504cb3ab4a1f626d174d2d");
        requestBody = new RequestBody();
        requestBody.setClave("06BRZ");
        requestBody.setPrimerApellido("BECERRA");
        requestBody.setProducto("64");
        requestBody.setUsuario("91518562");
        List<Parametros> parametros = new ArrayList<>();
        Parametros parametro = new Parametros();
        parametro.setNombre("ANIO_NACIMIENTO");
        parametro.setTipo("T");
        parametro.setValor("1980");
        parametros.add(parametro);
        requestBody.setParametros(parametros);
        request = RequestDictum.builder()
                .requestBody(requestBody)
                .requestHeader(requestHeader)
                .build();
        properties = new ClientesProperties();
        properties.setUriDictum(URI);
        dictumService = new DictumServiceImpl(restTemplateService, properties, modelMapper);
        headers = new HashMap<>();
        headers.put("idRequest", "1");
        headers.put("idCache", "{}");
    }

    @Test
    public void testDictumSuccessPREAPROBADO_CON_DOCUMENTOS() {
        Mockito.when(restTemplateService.getWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of("PREAPROBADO_CON_DOCUMENTOS"));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_PREAPROBADO_CON_DOCUMENTOS);
    }

    @Test
    public void testDictumSuccessAPROBADO() {
        Mockito.when(restTemplateService.getWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(MockResponseDictumTest.APROBADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_APROBADO);
    }

    @Test
    public void testDictumSuccessNEGADO() {
        Mockito.when(restTemplateService.getWithOutParams(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(MockResponseDictumTest.NEGADO));
        Optional<String> result = dictumService.consultarSolicitudDictum(request, 1L);
        Assert.assertEquals(result.get(), RESPUESTA_NEGADO);
    }

    private Optional<Map<String, String>> setHeaders(RequestDictum request, Long idRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest.toString());
        headers.put("idCache", new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .identificacion(request.getRequestHeader().getIdentificacion())
                .primerApellido(request.getRequestBody().getPrimerApellido())
                .tipoIdentificacion(request.getRequestHeader().getTipoIdentificacion())
                .build()));
        return Optional.of(headers);

    }


}
