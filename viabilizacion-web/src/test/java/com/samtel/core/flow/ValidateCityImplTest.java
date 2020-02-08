package com.samtel.core.flow;
	
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samtel.core.flow.impl.ValidateCityImpl;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateCityImplTest {

    private ValidateRequest validateRequest;
    @Mock
    private ValidateRequest next;

    private Cliente cliente;
    @Mock
    private String requestId;

    @Before
    public void setUp(){
        validateRequest = new ValidateCityImpl(next);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateCityImplSuccess() {
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED);
        Assert.assertNotNull( result );
    }
}
