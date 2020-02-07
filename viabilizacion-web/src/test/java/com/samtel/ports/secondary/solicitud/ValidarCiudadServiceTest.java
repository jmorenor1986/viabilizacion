package com.samtel.ports.secondary.solicitud;

import com.samtel.adapters.secondary.rest.impl.ValidarCiudadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidarCiudadServiceTest {
    public static final String CODIGO_CIUDAD = "001";
    private ValidarCiudadService validarCiudadService;


    @Before
    public void setUp() {
        validarCiudadService = new ValidarCiudadServiceImpl();
    }

    @Test
    @Ignore
    public void testValidarCiudadSuccess() {
        Boolean result = validarCiudadService.validarCodigoCiudad(CODIGO_CIUDAD);
        Assert.assertEquals(result, Boolean.TRUE);
    }

}
