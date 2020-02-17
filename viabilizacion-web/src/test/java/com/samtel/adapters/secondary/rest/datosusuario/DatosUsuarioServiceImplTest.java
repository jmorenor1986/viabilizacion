package com.samtel.adapters.secondary.rest.datosusuario;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.ReconocerProperties;
import com.samtel.domain.solicitud.datosusuario.DatosUsuarioComplemento;
import com.samtel.domain.solicitud.datosusuario.RequestDatosUsuario;
import com.samtel.domain.solicitud.datosusuario.ResponseDatosUsuario;
import com.samtel.ports.secondary.solicitud.DatosUsuarioService;
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
public class DatosUsuarioServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private DatosUsuarioService datosUsuarioService;
    private ClientesProperties properties;

    @Mock
    private RestTemplateService restTemplateService;

    @Mock
    private JsonUtilities jsonUtilities;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        ReconocerProperties reconocerProperties = ReconocerProperties.builder()
                .nit("12345678")
                .numeroIdBuscar("1234444")
                .tipoIdBuscar("1")
                .validarNombre("true")
                .uri("http://www.mocky.io/v2/5e43f8bd31000013413b0393")
                .build();
        properties.setReconocerProperties(reconocerProperties);
        datosUsuarioService = new DatosUsuarioServiceImpl(restTemplateService, properties, jsonUtilities);
    }

    @Test
    public void testReturnTelefonosOrDireccionesReconocer() {
        RequestDatosUsuario requestDatosUsuario = RequestDatosUsuario.builder()
                .numeroDocumento("101020220")
                .primerApellido("PEREZ")
                .tipoDocumento("1")
                .build();
        ResponseDatosUsuario responseDatosUsuario = ResponseDatosUsuario.builder()
                .direcciones(new ArrayList<>())
                .numeroCelular(new ArrayList<>())
                .numerosTelefono(new ArrayList<>())
                .build();
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestDatosUsuario.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestDatosUsuario.getPrimerApellido());
        map.put("tipoId", requestDatosUsuario.getTipoDocumento());
        map.put("nit", properties.getReconocerProperties().getNit());
        map.put("tipoIdBuscar", properties.getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", properties.getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", properties.getReconocerProperties().getValidarNombre());
        Mockito.when(restTemplateService.getWithParams(properties.getReconocerProperties().getUri(), map)).thenReturn(Optional.of(MockReconocerService.response));
        ResponseDatosUsuario result = datosUsuarioService.consultarDatosUsuario(requestDatosUsuario);
        Assert.assertNotNull(result);
        Assert.assertNotNull(responseDatosUsuario);
    }

    @Test
    public void testConsultarTelefonosDireccionesUbica() {
        DatosUsuarioComplemento datosUsuarioComplemento = DatosUsuarioComplemento
                .builder().build();

    }
}
