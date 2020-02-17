package com.samtel.adapters.secondary.rest.dictum.mapper.impl;

import com.samtel.domain.solicitud.dictum.RequestBody;
import com.samtel.domain.solicitud.dictum.RequestHeader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;

@SpringBootTest
public class DictumClienteMapperImplTest {

	private DictumClienteMapper dictumClienteMapper;

	@Mock
	private RequestHeader requestHeader;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dictumClienteMapper = new DictumClienteMapperImpl(requestHeader);
	}
	
	@Test
	public void testClientToRequestDictum() {
		
	}
}
