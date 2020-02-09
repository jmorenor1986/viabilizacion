package com.samtel.core.flow;

import com.samtel.core.flow.impl.SearchReconocerImpl;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.utils.impl.GenerateUniqueIdImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchReconocerImplTest {

    private ValidateRequest validateRequest;
    
    private GenerateUniqueIdImpl generateUniqueId;
    @Mock
    private ValidateRequest next;
    @Mock
    private Cliente cliente;
    
    private String requestId;

    @Before
    public void setUp(){
        validateRequest = new SearchReconocerImpl(next);
        generateUniqueId = new GenerateUniqueIdImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchReconocerImplSuccess(){
    	requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
        String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
        Assert.assertNotNull(result);
    }

}