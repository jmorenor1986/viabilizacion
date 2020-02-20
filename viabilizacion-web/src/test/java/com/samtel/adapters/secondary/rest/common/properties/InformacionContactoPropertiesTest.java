package com.samtel.adapters.secondary.rest.common.properties;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InformacionContactoPropertiesTest {

	@Test
	public void testReconocerProperties() {
		Assert.assertThat(InformacionContactoProperties.class,
				CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(), BeanMatchers.hasValidBeanConstructor(),
						BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode(), 
						BeanMatchers.hasValidBeanToString()));
	}
}
