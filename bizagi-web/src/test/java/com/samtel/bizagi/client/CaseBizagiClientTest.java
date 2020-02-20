package com.samtel.bizagi.client;

import com.samtel.bizagi.client.impl.CaseBizagiClientImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaseBizagiClientTest {
    private CaseBizagiClient caseBizagiClient;

    @Before
    public void setUp() {
        caseBizagiClient = new CaseBizagiClientImpl();
    }

    @Test
    public void testCreateCaseBizagi() {
        Object request = new Object();
        Object result = caseBizagiClient.createCase(request);
        Assert.assertNotNull(result);
    }
}
