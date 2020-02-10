package com.samtel.core.flow.impl;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import com.samtel.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


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
        MockitoAnnotations.initMocks(this);
        validateRequest = new ValidateCityImpl(next, validarCiudad);
        generateUniqueId = new GenerateUniqueIdImpl();
    }

    @Test
    public void testValidateCityImplSuccess() {
    	requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED);
        Assert.assertNotNull( result );
    }
}
