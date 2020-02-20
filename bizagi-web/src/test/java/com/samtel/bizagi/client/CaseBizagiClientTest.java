package com.samtel.bizagi.client;

import com.samtel.bizagi.client.impl.CaseBizagiClientImpl;
import com.samtel.bizagi.common.properties.ServiciosProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaseBizagiClientTest {
    private CaseBizagiClient caseBizagiClient;
    private ServiciosProperties serviciosProperties;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        serviciosProperties = new ServiciosProperties();
        serviciosProperties.setUriCrearCaso("www.google.com");
        caseBizagiClient = new CaseBizagiClientImpl(serviciosProperties);
    }

    @Test
    public void testCreateCaseBizagi() {
        Object request = new Object();
        Object result = caseBizagiClient.createCase(request);
        Assert.assertNotNull(result);
        Assert.assertNotNull(serviciosProperties.getUriCrearCaso());
    }
}
