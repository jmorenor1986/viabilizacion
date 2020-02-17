package com.samtel.adapters.secondary.rest.common.properties;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

@SpringBootTest
public class ClientesPropertiesTest {

	@Test
	public void testClientesProperties() {
		Assert.assertThat(ClientesProperties.class, CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(),
				BeanMatchers.hasValidBeanToString(), BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode()));
	}
}
