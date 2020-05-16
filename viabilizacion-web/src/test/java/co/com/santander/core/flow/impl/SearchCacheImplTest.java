package co.com.santander.core.flow.impl;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchCacheImplTest {

    private ValidateRequest validateRequest;
    
    private GenerateUniqueIdImpl generateUniqueId;
    @Mock
    private ValidateRequest next;
    @Mock
    private Cliente cliente;
   
    private String requestId;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        validateRequest = new SearchCacheImpl(next);
        generateUniqueId = new GenerateUniqueIdImpl();
    }

    @Test
    public void testSearchCacheImplSuccess(){
        Long requestId = Long.valueOf("1");
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.NEGADO);
        Assert.assertNotNull(result);
    }
}
