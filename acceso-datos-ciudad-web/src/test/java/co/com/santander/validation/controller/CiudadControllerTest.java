package co.com.santander.validation.controller;

import co.com.santander.validation.dto.GeneralPayload;
import co.com.santander.validation.dto.ResponsePayLoad;
import co.com.santander.validation.dto.ValidarCiudad;
import co.com.santander.validation.service.CiudadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


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
        ResponseEntity<ResponsePayLoad> result = ciudadController.validarCiudad(GeneralPayload.<ValidarCiudad>builder()
                .requestBody(ValidarCiudad.builder().ciudad(CIUDAD_TEST).build())
                .build());
        Assert.assertEquals("true", result.getBody().getRespuestaServicio());
    }


}
