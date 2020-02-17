package com.samtel.adapters.secondary.rest.informacioncontacto;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import com.samtel.domain.solicitud.datosusuario.RequestInformacionContacto;
import com.samtel.domain.solicitud.datosusuario.ResponseInformacionContacto;
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

    @Mock
    private JsonUtilities jsonUtilities;

    private RequestInformacionContacto requestInformacionContacto;
    private ResponseInformacionContacto responseInformacionContacto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
        InformacionContactoProperties informacionContactoProperties = InformacionContactoProperties.builder()
                .nit("12345678")
                .numeroIdBuscar("1234444")
                .tipoIdBuscar("1")
                .validarNombre("true")
                .uri("http://www.mocky.io/v2/5e43f8bd31000013413b0393")
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

        Mockito.when(restTemplateService.getWithOutParams(properties.getInformacionContactoProperties().getUbicaProperties().getUri(),))
        ResponseInformacionContacto informacionContacto = informacionContactoService.consultarInformacionContacto(requestInformacionContacto);

    }
}
