package com.samtel.bizagi.service;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.dto.ResponseCreateCaseDTO;
import com.samtel.bizagi.service.impl.CaseBizagiServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;

@SpringBootTest
public class CaseBizagiServiceTest {

    private CaseBizagiService caseBizagiService;

    @Mock
    private CaseBizagiClient caseBizagiClient;
    @Mock
    private RequestCreateCaseDTO requestCreateCaseDTO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        caseBizagiService = new CaseBizagiServiceImpl(caseBizagiClient);
    }

    @Test
    public void testCreateCaseSuccess() throws MalformedURLException {
        Mockito.when(caseBizagiClient.createCase(requestCreateCaseDTO)).thenReturn(new ResponseCreateCaseDTO());
        ResponseCreateCaseDTO result = caseBizagiService.createCase(requestCreateCaseDTO);
        Assert.assertNotNull(result);
        Assert.assertNotNull(new ResponseCreateCaseDTO());
        Assert.assertNotNull(new RequestCreateCaseDTO());
    }
}
