package co.com.santander.core.flow.impl;

import co.com.santander.adapters.secondary.rest.bizagi.BizagiServiceImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.EnvioCorreoService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchBizagiImplTest {
	
	private ValidateRequest validateRequest;

	private GenerateUniqueIdImpl generateUniqueId;
	

	@Mock
	private BizagiServiceImpl bizagiService;
	@Mock
	private EnvioCorreoService envioCorreoService;

	private Long requestId;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		validateRequest = new SearchBizagiImpl(bizagiService, envioCorreoService);
		generateUniqueId = new GenerateUniqueIdImpl();

	}

	@Test
	public void testSearchReconocerImplSuccess() {
		requestId = Long.valueOf("1");
		Cliente cliente = Cliente.builder()
				.decisionFinal(ResponseFlow.PREAPROBADO_SIN_DOCUMENTOS)
				.build();
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.NEGADO).toString();
		Assert.assertNotNull(result);
	}

}
