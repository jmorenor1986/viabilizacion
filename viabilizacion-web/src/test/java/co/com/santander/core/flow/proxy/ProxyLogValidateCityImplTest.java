package co.com.santander.core.flow.proxy;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.primary.log.LogService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProxyLogValidateCityImplTest {

    private ValidateRequest validateRequest;
    
    private GenerateUniqueIdImpl generateUniqueId;
    @Mock
    private LogService logService; 
    
    @Mock
    private ValidateRequest next;
    
    private Cliente cliente;
    
    private String requestId;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        validateRequest = new ProxyLogValidateCityImpl(next,logService);
        generateUniqueId = new GenerateUniqueIdImpl();
        cliente= Cliente.builder().actividad("Actividad")
                .anoNacimiento("anoNacimiento")
                .apellidos("apellidos")
                .celular("celular")
                .correoElectronico("correoElectronio")
                .direccion("direccion")
                .ingresos("ingresos")
                .nombres("nombres")
                .numeroIdentificacion("numer0")
                .plazo("plazo")
                .telefono("telefono")
                .tipoIdentificacion("tipoIdentificacion")
                .valorSolicitado("valorsolicitado")
                .build();
    }

    @Test
    public void testValidateCityImplSuccess() {
    	requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED);
        Assert.assertNotNull( result );
    }
}