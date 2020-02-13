package com.samtel.adapters.secondary.rest.reconocer;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.config.properties.ClientesProperties;
import com.samtel.config.properties.ReconocerProperties;
import com.samtel.domain.solicitud.reconocer.RequestReconocer;
import com.samtel.domain.solicitud.reconocer.ResponseReconocer;
import com.samtel.ports.secondary.solicitud.ReconocerService;
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
public class ReconocerServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private ReconocerService reconocerService;
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
        reconocerService = new ReconocerServiceImpl(restTemplateService, properties, jsonUtilities);
    }

    @Test
    public void testReturnTelefonosOrDirecciones() {
        RequestReconocer requestReconocer = RequestReconocer.builder()
                .numeroDocumento("101020220")
                .primerApellido("PEREZ")
                .tipoDocumento("1")
                .build();
        ResponseReconocer responseReconocer = ResponseReconocer.builder()
                .direcciones(new ArrayList<>())
                .numeroCelular("")
                .numerosTelefono("")
                .build();
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestReconocer.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestReconocer.getPrimerApellido());
        map.put("tipoId", requestReconocer.getTipoDocumento());
        map.put("nit", properties.getReconocerProperties().getNit());
        map.put("tipoIdBuscar", properties.getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", properties.getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", properties.getReconocerProperties().getValidarNombre());
        Mockito.when(restTemplateService.getWithParams(properties.getReconocerProperties().getUri(), map)).thenReturn(Optional.of(MockReconocerService.response));
        ResponseReconocer result = reconocerService.consultarDatosUsuario(requestReconocer);
        Assert.assertNotNull(result);
        Assert.assertNotNull(responseReconocer);
    }


}
