package com.samtel.core.flow.impl;
	
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.flow.impl.ValidateCityImpl;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import com.samtel.utils.impl.GenerateUniqueIdImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateCityImplTest {

    private ValidateRequest validateRequest;
    
    @Mock
    private ValidarCiudadService validarCiudad;
    
    private GenerateUniqueIdImpl generateUniqueId;
    
    @Mock
    private ValidateRequest next;
    @Mock
    private Cliente cliente;
    
    private String requestId;

    @Before
    public void setUp(){
        validateRequest = new ValidateCityImpl(next, validarCiudad);
        generateUniqueId = new GenerateUniqueIdImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateCityImplSuccess() {
    	requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED);
        Assert.assertNotNull( result );
    }
}
