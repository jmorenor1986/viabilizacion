package co.com.santander.bizagi.controller;

import co.com.santander.bizagi.service.CaseBizagiService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CaseBizagiControllerTest {
    private CaseBizagiController caseBizagiController;
    @Mock
    private CaseBizagiService caseBizagiService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        caseBizagiController = new CaseBizagiController(caseBizagiService);
    }

    //@Test
    //public void testCreateCaseSuccess() throws MalformedURLException, JSONException {
    //    Mockito.when(caseBizagiService.createCaseString(Mockito.any())).thenReturn(new String());
    //    ResponseEntity result = caseBizagiController.createCase(Mockito.any());
    //    Assert.assertNotNull(result);
    //}

}
