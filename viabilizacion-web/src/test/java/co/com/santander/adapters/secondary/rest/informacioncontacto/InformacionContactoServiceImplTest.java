package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.JsonUtilitiesImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.ReconocerProperties;
import co.com.santander.adapters.secondary.rest.common.properties.UbicaProperties;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.RequestUbicaDTO;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
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
public class InformacionContactoServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private InformacionContactoService informacionContactoService;
    private ClientesProperties properties;

    @Mock
    private RestTemplateService restTemplateService;

    private Map<String,String> headers;


    private JsonUtilities jsonUtilities;

    private InformacionContacto informacionContacto;
    private ResponseInformacionContacto responseInformacionContacto;
    private InformacionContactoProperties informacionContactoProperties;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jsonUtilities = new JsonUtilitiesImpl();
        properties = new ClientesProperties();
        informacionContacto = InformacionContacto.builder()
                .numeroDocumento("101020220")
                .primerApellido("PEREZ")
                .tipoDocumento("1")
                .build();
        responseInformacionContacto = ResponseInformacionContacto.builder()
                .direcciones(new ArrayList<>())
                .numeroCelular(new ArrayList<>())
                .numerosTelefono(new ArrayList<>())
                .build();
        ReconocerProperties reconocerProperties = ReconocerProperties.builder()
                .numeroIdBuscar("1010101010")
                .tipoIdBuscar("1")
                .nit("900468987")
                .uri("http://www.mocky.io/v2/5e4473f731000098df3b06ff")
                .validarNombre("true")
                .build();
        UbicaProperties ubicaProperties = UbicaProperties.builder()
                .codigoInformacion("5632")
                .motivoConsulta("1")
                .uri("http://www.mocky.io/v2/5e492eae3000004a008c2cf7")
                .build();
        informacionContactoProperties = InformacionContactoProperties.builder()
                .reconocerProperties(reconocerProperties)
                .ubicaProperties(ubicaProperties)
                .build();
        properties.setInformacionContactoProperties(informacionContactoProperties);
        informacionContactoService = new InformacionContactoServiceImpl(restTemplateService, properties, jsonUtilities);
        headers = new HashMap<>();
        headers.put("idRequest", "123");
    }

    @Test
    public void testReturnTelefonosOrDireccionesReconocer() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", informacionContacto.getNumeroDocumento());
        map.put("primerApellidoBuscar", informacionContacto.getPrimerApellido());
        map.put("tipoId", informacionContacto.getTipoDocumento());
        map.put("nit", properties.getInformacionContactoProperties().getReconocerProperties().getNit());
        map.put("tipoIdBuscar", properties.getInformacionContactoProperties().getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", properties.getInformacionContactoProperties().getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", properties.getInformacionContactoProperties().getReconocerProperties().getValidarNombre());

        Mockito.when(restTemplateService.getWithParams(properties.getInformacionContactoProperties().getReconocerProperties().getUri(), map, Optional.of(headers))).thenReturn(Optional.of(MockReconocerService.response));
        ResponseInformacionContacto result = informacionContactoService.consultarDatosUsuario(informacionContacto, "123");
        Assert.assertNotNull(result);
        Assert.assertNotNull(responseInformacionContacto);
    }

    @Test
    public void testConsultarTelefonosDireccionesUbica() {
        RequestUbicaDTO requestUbicaDTO = RequestUbicaDTO.builder()
                .codigoInformacion(properties.getInformacionContactoProperties().getUbicaProperties().getCodigoInformacion())
                .motivoConsulta(properties.getInformacionContactoProperties().getUbicaProperties().getMotivoConsulta())
                .numeroIdentificacion(informacionContacto.getNumeroDocumento())
                .primerApellido(informacionContacto.getPrimerApellido())
                .tipoIdentificacion(informacionContacto.getTipoDocumento())
                .build();
        Mockito.when(restTemplateService.getWithOutParams(properties.getInformacionContactoProperties().getUbicaProperties().getUri(), requestUbicaDTO, Optional.of(headers))).thenReturn(Optional.of(MockUbicaService.response));
        ResponseInformacionContacto informacionContacto = informacionContactoService.consultarInformacionContacto(this.informacionContacto, "123");
        Assert.assertNotNull(informacionContacto);

    }
}
