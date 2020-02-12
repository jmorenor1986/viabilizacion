package com.samtel.adapters.secondary.rest.reconocer;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.config.ClientesProperties;
import com.samtel.ports.secondary.solicitud.ReconocerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReconocerServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private ReconocerService reconocerService;
    private ClientesProperties properties;

    @Mock
    private RestTemplateService restTemplateService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties= new ClientesProperties();
        properties.setUriReconocer(URI_RECONOCER);
        reconocerService = new ReconocerServiceImpl(restTemplateService,properties);
    }

    @Test
    public void testReturnTelefonosOrDirecciones(){
        Object result = reconocerService.consultarDatosUsuario(new Object());
    }


}
