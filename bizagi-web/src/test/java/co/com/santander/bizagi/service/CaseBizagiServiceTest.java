package co.com.santander.bizagi.service;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.client.MockResponseCreateCase;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.dto.RequestCreateCaseDTO;
import co.com.santander.bizagi.service.impl.CaseBizagiServiceImpl;
import co.com.santander.bizagi.util.StringUtilities;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringWriter;
import java.net.MalformedURLException;

@SpringBootTest
public class CaseBizagiServiceTest {

    private CaseBizagiService caseBizagiService;

    @Mock
    private CaseBizagiClient caseBizagiClient;
    @Mock
    private RequestCreateCaseDTO requestCreateCaseDTO;
    private VelocityEngine velocityEngine;
    private VelocityContext context;
    private StringWriter stringWriter;
    private StringUtilities stringUtilities;
    private ServiciosProperties serviciosProperties;

    @Before
    public void setUp() {
        serviciosProperties = new ServiciosProperties();
        MockitoAnnotations.initMocks(this);
        serviciosProperties.setKeyStore("123456");
        serviciosProperties.setKeyStorePassword("123456");
        serviciosProperties.setTrustStore("1234567");
        serviciosProperties.setTrustStorePassword("12345678");
        serviciosProperties.setUriCrearCaso("12345678");
        serviciosProperties.setDomain("2345678");
        serviciosProperties.setProcess("23456789");
        serviciosProperties.setUserName("1234567");
        serviciosProperties.setAutorizaConsultaaCentrales("1");
        stringUtilities = new StringUtilities();
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,
                "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        context = new VelocityContext();
        stringWriter = new StringWriter();
        caseBizagiService = new CaseBizagiServiceImpl(caseBizagiClient, velocityEngine, context, stringWriter, stringUtilities, serviciosProperties);
    }

    @Test
    public void testCreateCaseSuccess() throws MalformedURLException, JSONException {
        RequestCreateCaseDTO requestCreateCaseDTOTest = new RequestCreateCaseDTO();
        requestCreateCaseDTOTest.setBuroScore("5");
        requestCreateCaseDTOTest.setDocumentNumber("785621");
        requestCreateCaseDTOTest.setDomain("domain");
        requestCreateCaseDTOTest.setProcess("Credit");
        requestCreateCaseDTOTest.setTypeDocument("CC");
        requestCreateCaseDTOTest.setUserName("admon");

        Mockito.when(caseBizagiClient.createCaseString(MockRequestCreateCase.request)).thenReturn(MockResponseCreateCase.response);
        String result = caseBizagiService.createCaseString(requestCreateCaseDTOTest);
        Assert.assertNotNull(result);
    }
}
