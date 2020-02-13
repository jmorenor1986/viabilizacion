
package com.samtel.adapters.secondary.rest.validarciudad;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.config.properties.ClientesProperties;
import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class ValidarCiudadServiceImplTest {
    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";
    public static final String NOMBRE_CIUDAD = "BOGOTA";
    private ValidarCiudadService validarCiudadService;
    private ClientesProperties properties;
    @Mock
    private RestTemplateService restTemplateService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriValidarCiudad(URI);
        validarCiudadService = new ValidarCiudadServiceImpl(restTemplateService, properties);
    }

    @Test
    public void testValidarCiudadReturnTrue() {
        Mockito.when(restTemplateService.getWithPathParams(properties.getUriValidarCiudad(), new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)))).thenReturn(Optional.of("true"));
        String result = validarCiudadService.validarCodigoCiudad(NOMBRE_CIUDAD);
        Assert.assertEquals("true", result);
    }

    @Test
    public void testValidarCiudadReturnFalse() {
        Mockito.when(restTemplateService.getWithPathParams(properties.getUriValidarCiudad(), new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)))).thenReturn(Optional.of("false"));
        String result = validarCiudadService.validarCodigoCiudad(NOMBRE_CIUDAD);
        Assert.assertEquals("false", result);
    }

}
