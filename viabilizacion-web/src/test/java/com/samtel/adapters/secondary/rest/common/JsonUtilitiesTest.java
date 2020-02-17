package com.samtel.adapters.secondary.rest.common;

import com.samtel.adapters.secondary.rest.informacioncontacto.MockReconocerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JsonUtilitiesTest {
    private JsonUtilities jsonUtilities;

    @Before
    public void setUp() {
        jsonUtilities = new JsonUtilitiesImpl();
    }

    @Test
    public void testGetObjectWithKey() {
        String resultado = jsonUtilities.getObjectWithKey("reporte.celulares", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testGetObjectWithKeyNotExist() {
        String resultado = jsonUtilities.getObjectWithKey("reporte.repi", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testGetPropertyObjectWithKey() {
        String resultado = jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testGetPropertyObjectWithKeyNotExist() {
        String resultado = jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "reporte", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testGetValuesForGivenKey() {
        List<String> resultado = jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testGetValuesForGivenKeyNotExist() {
        List<String> resultado = jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dictum", MockReconocerService.response);
        Assert.assertNotNull(resultado);
    }
}
