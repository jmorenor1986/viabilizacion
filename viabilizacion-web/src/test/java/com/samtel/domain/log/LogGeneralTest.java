package com.samtel.domain.log;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

@SpringBootTest
public class LogGeneralTest {
	@Test
	public void testLogGeneral() {
		Assert.assertNotNull(LogGeneral.builder().id(Long.valueOf("1")).fecha(new Date()).build());
		Assert.assertNotNull(LogGeneral.builder().id(Long.valueOf("1")).fecha(new Date()).build().toString());
		Assert.assertThat(LogGeneral.class, CoreMatchers.allOf(
                BeanMatchers.hasValidGettersAndSetters()));
	}
}
