package com.samtel.adapters.secondary.rest.informacioncontacto;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.JsonUtilitiesImpl;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import com.samtel.adapters.secondary.rest.common.properties.ReconocerProperties;
import com.samtel.adapters.secondary.rest.common.properties.UbicaProperties;
import com.samtel.adapters.secondary.rest.informacioncontacto.dto.RequestUbicaDTO;
import com.samtel.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import com.samtel.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import com.samtel.ports.secondary.solicitud.InformacionContactoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@SpringBootTest
public class InformacionContactoServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private InformacionContactoService informacionContactoService;
    private ClientesProperties properties;

    @Mock
    private RestTemplateService restTemplateService;


    private JsonUtilities jsonUtilities;

    private RequestInformacionContacto requestInformacionContacto;
    private ResponseInformacionContacto responseInformacionContacto;
    private InformacionContactoProperties informacionContactoProperties;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jsonUtilities = new JsonUtilitiesImpl();
        properties = new ClientesProperties();
        requestInformacionContacto = RequestInformacionContacto.builder()
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
    }

    @Test
    public void testReturnTelefonosOrDireccionesReconocer() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestInformacionContacto.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestInformacionContacto.getPrimerApellido());
        map.put("tipoId", requestInformacionContacto.getTipoDocumento());
        map.put("nit", properties.getInformacionContactoProperties().getReconocerProperties().getNit());
        map.put("tipoIdBuscar", properties.getInformacionContactoProperties().getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", properties.getInformacionContactoProperties().getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", properties.getInformacionContactoProperties().getReconocerProperties().getValidarNombre());
        Mockito.when(restTemplateService.getWithParams(properties.getInformacionContactoProperties().getReconocerProperties().getUri(), map)).thenReturn(Optional.of(MockReconocerService.response));
        ResponseInformacionContacto result = informacionContactoService.consultarDatosUsuario(requestInformacionContacto);
        Assert.assertNotNull(result);
        Assert.assertNotNull(responseInformacionContacto);
    }

    @Test
    public void testConsultarTelefonosDireccionesUbica() {
        RequestUbicaDTO requestUbicaDTO = RequestUbicaDTO.builder()
                .codigoInformacion(properties.getInformacionContactoProperties().getUbicaProperties().getCodigoInformacion())
                .motivoConsulta(properties.getInformacionContactoProperties().getUbicaProperties().getMotivoConsulta())
                .numeroIdentificacion(requestInformacionContacto.getNumeroDocumento())
                .primerApellido(requestInformacionContacto.getPrimerApellido())
                .tipoIdentificacion(requestInformacionContacto.getTipoDocumento())
                .build();

        Mockito.when(restTemplateService.getWithOutParams(properties.getInformacionContactoProperties().getUbicaProperties().getUri(), requestUbicaDTO)).thenReturn(Optional.of(MockUbicaService.response));
        ResponseInformacionContacto informacionContacto = informacionContactoService.consultarInformacionContacto(requestInformacionContacto);
        Assert.assertNotNull(informacionContacto);

    }
}
