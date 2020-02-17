package com.samtel.adapters.secondary.rest.dictum.mapper.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;

@SpringBootTest
public class DictumClienteMapperImplTest {

	private DictumClienteMapper dictumClienteMapper;	

	@Before
	public void setUp() {
		dictumClienteMapper = new DictumClienteMapperImpl();
	}
	
	@Test
	public void testClientToRequestDictum() {
		
	}
}
