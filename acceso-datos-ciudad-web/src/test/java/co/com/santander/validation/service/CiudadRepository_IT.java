package co.com.santander.validation.service;

import co.com.santander.validation.entity.Ciudad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CiudadRepository_IT {
    @Autowired
    private CiudadRepository repository;

    @Test
    public void testGetCiudadSuccess() {
        Ciudad result = repository.buscarPorCodigoONombre("BOGOTA");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetCiudadNotExist() {
        Ciudad result = repository.buscarPorCodigoONombre("TUNJA");
        Assert.assertNull(result);
    }

    @Test
    public void testGetALL() {
        List<Ciudad> result = repository.findAll();
        Assert.assertNotNull(result);
    }

}
