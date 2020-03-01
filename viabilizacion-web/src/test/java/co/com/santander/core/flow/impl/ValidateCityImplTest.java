package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
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
