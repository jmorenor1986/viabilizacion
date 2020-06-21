package co.com.santander.validation.service;

import co.com.santander.validation.entity.Ciudad;
import co.com.santander.validation.service.impl.CiudadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class CiudadServiceTest {

    public static final String NOMBRE_CIUDAD = "BOGOTA";
    public static final String RESPUESTA_FALSE = "INACTIVO";
    public static final String RESPUESTA_TRUE = "ACTIVO";
    private CiudadService ciudadService;

    @Mock
    private CiudadRepository ciudadRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ciudadService = new CiudadServiceImpl(ciudadRepository);

    }


    @Test
    public void testBuscaCodigoONombreSuccessFalse() {
        Ciudad ciudad = new Ciudad();
        ciudad.setEstado(RESPUESTA_FALSE);
        Mockito.when(ciudadRepository.buscarPorCodigoONombre(NOMBRE_CIUDAD)).thenReturn(ciudad);
        Boolean respuesta = ciudadService.validarCiudad(NOMBRE_CIUDAD);
        Assert.assertEquals(Boolean.FALSE, respuesta);
    }

    @Test
    public void testBuscaCodigoONombreSuccessTrue() {
        Ciudad ciudad = new Ciudad();
        ciudad.setEstado(RESPUESTA_TRUE);
        Mockito.when(ciudadRepository.buscarPorCodigoONombre(NOMBRE_CIUDAD)).thenReturn(ciudad);
        Boolean respuesta = ciudadService.validarCiudad(NOMBRE_CIUDAD);
        Assert.assertEquals(Boolean.TRUE, respuesta);
    }
    
    @Test
    public void testFindAllSuccess() {
    	List<Ciudad> ciuList = new ArrayList<Ciudad>();
    	Ciudad ciu = new Ciudad();
    	ciu.setId((long) 1);
    	ciu.setCodigo("0012");
    	ciu.setEstado("ACTIVO");
    	ciu.setNombre("BOGOTA");
    	ciuList.add(ciu);
    	
        Mockito.when(ciudadRepository.findAll()).thenReturn(ciuList);
        List<Ciudad> ciuResp = ciudadService.traerCiudades();
        Assert.assertEquals(ciuList, ciuResp);
    }

}
