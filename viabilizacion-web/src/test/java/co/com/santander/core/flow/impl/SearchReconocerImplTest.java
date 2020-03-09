package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchReconocerImplTest {

    private ValidateRequest validateRequest;
    
    private GenerateUniqueIdImpl generateUniqueId;
    @Mock
    private ValidateRequest next;
    @Mock
    private Cliente cliente;
    
    private Long requestId;
    @Mock
    private InformacionContactoService informacionContactoService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        validateRequest = new SearchReconocerImpl(next, informacionContactoService);
        generateUniqueId = new GenerateUniqueIdImpl();

    }

    @Test
    public void testSearchReconocerImplSuccess(){
        requestId = Long.valueOf("1");
        String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
        Assert.assertNotNull(result);
    }

}