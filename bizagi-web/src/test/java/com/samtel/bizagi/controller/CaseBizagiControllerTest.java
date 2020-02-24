package com.samtel.bizagi.controller;

import com.samtel.bizagi.dto.ResponseCreateCaseDTO;
import com.samtel.bizagi.service.CaseBizagiService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.tempuri.WorkflowEngineSOASoap;

import java.net.MalformedURLException;

public class CaseBizagiControllerTest {
    private CaseBizagiController caseBizagiController;
    @Mock
    private CaseBizagiService caseBizagiService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        caseBizagiController = new CaseBizagiController(caseBizagiService);
    }

    @Test
    public void testCreateCaseSuccess() throws MalformedURLException {
        Mockito.when(caseBizagiService.createCase(Mockito.any())).thenReturn(new ResponseCreateCaseDTO());
        ResponseCreateCaseDTO result = caseBizagiController.createCase(Mockito.any());
        Assert.assertNotNull(result);
    }

}
