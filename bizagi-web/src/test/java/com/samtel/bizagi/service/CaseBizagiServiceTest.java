package com.samtel.bizagi.service;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.client.MockResponseCreateCase;
import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.service.impl.CaseBizagiServiceImpl;
import com.samtel.bizagi.util.StringUtilities;
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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        stringUtilities = new StringUtilities();
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,
                "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        context = new VelocityContext();
        stringWriter = new StringWriter();
        caseBizagiService = new CaseBizagiServiceImpl(caseBizagiClient, velocityEngine, context, stringWriter, stringUtilities);
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
