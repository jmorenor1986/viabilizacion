package com.samtel.core.flow.proxy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.primary.log.LogService;
import com.samtel.utils.impl.GenerateUniqueIdImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyLogSearchBizagiImplTest {
	
	private ValidateRequest validateRequest;
	
	@Mock
    private LogService logService; 
    
	@Mock
    private ValidateRequest next;
	
	private GenerateUniqueIdImpl generateUniqueId;
	
	private Cliente cliente;

	private String requestId;

	@Before
	public void setUp() {
		validateRequest = new ProxyLogSearchBizagi(next, logService);
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
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSearchReconocerImplSuccess() {
		requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}

}