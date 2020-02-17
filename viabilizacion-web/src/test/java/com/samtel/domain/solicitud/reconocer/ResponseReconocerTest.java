package com.samtel.domain.solicitud.reconocer;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

@SpringBootTest
public class ResponseReconocerTest {

	@Test
	public void testResponseReconocer() {
		ResponseReconocer response = new ResponseReconocer();
		Assert.assertNotNull(response.hashCode());
		Assert.assertNotNull(response.equals(null));
		Assert.assertThat(ResponseReconocer.class, CoreMatchers.allOf(
				BeanMatchers.hasValidGettersAndSetters(),
				BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanToString()));
	}
}
