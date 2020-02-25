package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
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
	private Cliente cliente;

	private String requestId;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		validateRequest = new SearchBizagiImpl();
		generateUniqueId = new GenerateUniqueIdImpl();

	}

	@Test
	public void testSearchReconocerImplSuccess() {
		requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}

}
