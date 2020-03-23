package co.com.santander.core.domain.log;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.code.beanmatchers.BeanMatchers;

import co.com.santander.persistencia.service.dto.LogPayload;

@SpringBootTest
public class LogGeneralTest {
	@Test
	public void testLogGeneral() {
		Assert.assertNotNull(LogPayload.builder().id(Long.valueOf("1")).fecha(new Date()).build());
		Assert.assertNotNull(LogPayload.builder().id(Long.valueOf("1")).fecha(new Date()).build().toString());
		Assert.assertThat(LogPayload.class, CoreMatchers.allOf(
                BeanMatchers.hasValidGettersAndSetters()));
	}
}
