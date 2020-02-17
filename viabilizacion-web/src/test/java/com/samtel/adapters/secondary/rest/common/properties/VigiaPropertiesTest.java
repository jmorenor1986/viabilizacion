package com.samtel.adapters.secondary.rest.common.properties;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

@SpringBootTest
public class VigiaPropertiesTest {
	
	@Test
	public void testVigiaProperties() {
		Assert.assertThat(VigiaProperties.class, CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(),
				BeanMatchers.hasValidBeanToString(), BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode()));
	}

}
