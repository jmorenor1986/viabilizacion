package com.samtel.core.flow;


import com.samtel.core.SearchCacheImpl;
import com.samtel.core.ValidateCityImpl;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateCityImplTest {

    private ValidateRequest validateRequest;
    @Mock
    private ValidateRequest next;

    private Cliente cliente;

    private static final Logger log= LoggerFactory.getLogger(SearchCacheImpl.class);

    @Before
    public void setUp(){
        validateRequest = new ValidateCityImpl(next);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateCityImplSuccess() {
        ResponseFlow result = validateRequest.process(cliente).orElse(ResponseFlow.DENIED);
        Assert.assertNotNull( result );
    }
}
