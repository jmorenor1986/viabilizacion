package com.samtel.validation.service;

import com.samtel.validation.entity.Ciudad;
import com.samtel.validation.service.impl.CiudadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CiudadServiceTest {

    public static final String NOMBRE_CIUDAD = "BOGOTA";
    private CiudadService ciudadService;

    @Mock
    private CiudadRepository ciudadRepository;
    @Mock
    private Ciudad ciudad;

    @Before
    public void setUp() {
        ciudadService = new CiudadServiceImpl(ciudadRepository);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscaCodigoONombreSuccess() {
        Mockito.when(ciudadRepository.buscarPorCodigoONombre(NOMBRE_CIUDAD)).thenReturn(ciudad);
        Ciudad ciudadLocal = ciudadService.validarCiudad(NOMBRE_CIUDAD);
        Assert.assertNull(ciudadLocal);

    }
}
