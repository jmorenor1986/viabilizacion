package com.example.services;

import com.example.ports.primary.KeepAliveService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeepAliveServiceTest {

    private KeepAliveService keepAliveService;

    @Before
    public void setUp() {
        keepAliveService = new KeepAliveServiceImpl();
    }

    @Test
    public void testKeepAliveServiceSuccess() {
        String result = keepAliveService.getAlive();
        Assert.assertNotNull(result);
    }
}
