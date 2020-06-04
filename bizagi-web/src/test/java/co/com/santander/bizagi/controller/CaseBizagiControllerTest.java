package co.com.santander.bizagi.controller;

import co.com.santander.bizagi.common.generic.GeneralPayload;
import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.service.CaseBizagiService;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;

@SpringBootTest
public class CaseBizagiControllerTest {

    private CaseBizagiController caseBizagiController;
    @Mock
    private CaseBizagiService caseBizagiService;
    GeneralPayload<Cliente> clienteGeneralPayload;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        caseBizagiController = new CaseBizagiController(caseBizagiService);
        clienteGeneralPayload = GeneralPayload.<Cliente>builder()
                .requestBody(Cliente.builder()
                        .build())
                .build();
    }

    @Test
    public void testCreateCaseStringSuccess() throws MalformedURLException, JSONException {

        Mockito.when(caseBizagiService.createCaseString(clienteGeneralPayload.getRequestBody())).thenReturn(new String());
        ResponseEntity result = caseBizagiController.createCase(clienteGeneralPayload);
        Assert.assertNotNull(result);
    }

    @Test
    public void createCaseObject() throws MalformedURLException, JSONException {
        Mockito.when(caseBizagiService.createCase(clienteGeneralPayload.getRequestBody())).thenReturn(GenericResponse.builder().build());
        GenericResponse result = caseBizagiController.createCaseObject(clienteGeneralPayload);
        Assert.assertNotNull(result);
    }


}