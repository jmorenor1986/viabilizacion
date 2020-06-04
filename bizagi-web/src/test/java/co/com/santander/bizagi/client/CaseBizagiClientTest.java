package co.com.santander.bizagi.client;

import co.com.santander.bizagi.client.impl.CaseBizagiClientImpl;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.common.properties.SystemProperties;
import co.com.santander.bizagi.service.MockRequestCreateCase;
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
        serviciosProperties.setKeyStore("https://www.google.com");
        serviciosProperties.setTrustStore("https://www.google.com");
        serviciosProperties.setKeyStorePassword("https://www.google.com");
        serviciosProperties.setTrustStorePassword("https://www.google.com");
        System.setProperty(SystemProperties.JAVAX_NET_DEBUG, SystemProperties.VALUE_JAVAX_NET_DEBUG);
        System.setProperty(SystemProperties.JAVAX_NET_SSL_TRUST_STORE, serviciosProperties.getTrustStore());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_TRUST_STORE_PASSWORD, serviciosProperties.getTrustStorePassword());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_KEY_STORE, serviciosProperties.getKeyStore());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_KEY_STORE_PASSWORD, serviciosProperties.getKeyStorePassword());
        System.setProperty(SystemProperties.ORG_APACHE_CXF_STAX_ALLOW_INSECURE_PARSER, SystemProperties.VALUE_ALLOW_INSECURE_PARSER);
        Mockito.when(workflowEngineSOA.getWorkflowEngineSOASoap()).thenReturn(workflowEngineSOASoap);
        caseBizagiClient = new CaseBizagiClientImpl(workflowEngineSOA);
    }

    @Test
    public void testCreateCaseBizagi() throws MalformedURLException {
        Mockito.when(workflowEngineSOASoap.createCasesAsString(MockRequestCreateCase.request)).thenReturn(MockResponseCreateCase.response);
        String result = caseBizagiClient.createCaseString(MockRequestCreateCase.request);
        Assert.assertNotNull(result);
        Assert.assertNotNull(serviciosProperties.getUriCrearCaso());
    }

    @Test
    public void testCreateCaseObject() throws MalformedURLException {
        Mockito.when(workflowEngineSOASoap.createCases(Mockito.any())).thenReturn(new CreateCasesResponse.CreateCasesResult());
        CreateCasesResponse.CreateCasesResult result = caseBizagiClient.createCase(Mockito.any());
        Assert.assertNotNull(result);

    }
}
