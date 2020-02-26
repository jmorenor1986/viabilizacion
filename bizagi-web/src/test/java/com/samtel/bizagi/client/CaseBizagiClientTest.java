package com.samtel.bizagi.client;

import com.samtel.bizagi.client.impl.CaseBizagiClientImpl;
import com.samtel.bizagi.common.properties.ServiciosProperties;
import com.samtel.bizagi.service.MockRequestCreateCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.tempuri.CreateCases;
import org.tempuri.CreateCasesResponse;
import org.tempuri.WorkflowEngineSOA;
import org.tempuri.WorkflowEngineSOASoap;

import java.net.MalformedURLException;

@SpringBootTest
public class CaseBizagiClientTest {
    private CaseBizagiClient caseBizagiClient;
    private ServiciosProperties serviciosProperties;
    @Mock
    private WorkflowEngineSOA workflowEngineSOA;
    @Mock
    private WorkflowEngineSOASoap workflowEngineSOASoap;
    @Mock
    private CreateCasesResponse.CreateCasesResult createCasesResult;
    @Mock
    private CreateCases.CasesInfo request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        serviciosProperties = new ServiciosProperties();
        serviciosProperties.setUriCrearCaso("https://www.google.com");
        Mockito.when(workflowEngineSOA.getWorkflowEngineSOASoap()).thenReturn(workflowEngineSOASoap);
        caseBizagiClient = new CaseBizagiClientImpl(serviciosProperties, workflowEngineSOA);
    }

    @Test
    public void testCreateCaseBizagi() throws MalformedURLException {
        Mockito.when(workflowEngineSOASoap.createCasesAsString(Mockito.any())).thenReturn("sasas");
        String result = caseBizagiClient.createCaseString(MockRequestCreateCase.request);
        Assert.assertNotNull(result);
        Assert.assertNotNull(serviciosProperties.getUriCrearCaso());
    }
}
