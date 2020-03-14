package co.com.santander.bizagi.controller;

import co.com.santander.bizagi.service.CaseBizagiService;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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



}
