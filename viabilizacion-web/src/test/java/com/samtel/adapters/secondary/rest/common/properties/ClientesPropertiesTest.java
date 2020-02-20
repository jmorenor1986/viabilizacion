package com.samtel.adapters.secondary.rest.common.properties;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientesPropertiesTest {

	@Test
	public void testClientesProperties() {
		Assert.assertThat(ClientesProperties.class, CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(),
				BeanMatchers.hasValidBeanToString(), BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode()));
	}
}
