package com.samtel.core.flow;


import com.samtel.core.ValidateCityImpl;
import com.samtel.domain.solicitud.Cliente;
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
public class ValidateCityImplTest {

    private ValidateRequest validateRequest;
    @Mock
    private ValidateRequest next;

    private Cliente cliente;

    @Before
    public void setUp(){
        validateRequest = new ValidateCityImpl(next);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateCityImplSuccess() {
        Boolean result = validateRequest.process(cliente).orElse(Boolean.FALSE);
        Assert.assertEquals(result, Boolean.TRUE);
    }
}
