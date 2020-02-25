package co.com.santander.validation.controller;

import co.com.santander.validation.service.CiudadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CiudadControllerTest {
    public static final String CIUDAD_TEST = "BOGOTA";
    private CiudadController ciudadController;

    @Mock
    private CiudadService ciudadService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ciudadController = new CiudadController(ciudadService);

    }

    @Test
    public void testValidarCiudadSuccess() {
        Mockito.when(ciudadService.validarCiudad(CIUDAD_TEST)).thenReturn(Boolean.TRUE);
        Boolean result = ciudadController.validarCiudad(CIUDAD_TEST);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
