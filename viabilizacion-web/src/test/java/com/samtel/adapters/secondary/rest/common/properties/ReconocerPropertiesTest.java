package com.samtel.adapters.secondary.rest.common.properties;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

@SpringBootTest
public class ReconocerPropertiesTest {

	@Test
	public void testReconocerProperties() {
		Assert.assertThat(ReconocerProperties.class,
				CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(), BeanMatchers.hasValidBeanConstructor(),
						BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode(), 
						BeanMatchers.hasValidBeanToString()));
	}
}
