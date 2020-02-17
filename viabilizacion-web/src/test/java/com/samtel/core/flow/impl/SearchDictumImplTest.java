package com.samtel.core.flow.impl;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;
import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.secondary.solicitud.DictumService;
import com.samtel.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchDictumImplTest {
	
	private ValidateRequest validateRequest;

	private GenerateUniqueIdImpl generateUniqueId;
	
	@Mock
    private ValidateRequest next;
	@Mock
	private DictumService dictumService;
	@Mock
	private Cliente cliente;
	@Mock
	private DictumClienteMapper dictumClienteMapper;

	private String requestId;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		validateRequest = new SearchDictumImpl(next, dictumService, dictumClienteMapper);
		generateUniqueId = new GenerateUniqueIdImpl();
	}

	@Test
	public void testSearchReconocerImplSuccess() {
		requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}

}
