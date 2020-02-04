package com.samtel.ports.secondary.solicitud;

import com.samtel.adapters.secondary.database.solicitud.ValidarCiudadRepository;
import com.samtel.adapters.secondary.database.solicitud.ValidarCiudadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidarCiudadServiceTest {
    public static final String CODIGO_CIUDAD = "001";
    private ValidarCiudadService validarCiudadService;

    @Mock
    private ValidarCiudadRepository validarCiudadRepository;

    @Before
    public void setUp() {
        validarCiudadService = new ValidarCiudadServiceImpl(validarCiudadRepository);
    }

    @Test
    public void testValidarCiudadSuccess() {
        Mockito.when(validarCiudadRepository.validarCodigoCiudad(CODIGO_CIUDAD)).thenReturn(Boolean.TRUE);
        Boolean result = validarCiudadService.validarCodigoCiudad(CODIGO_CIUDAD);
        Assert.assertEquals(result, Boolean.TRUE);
    }

}
