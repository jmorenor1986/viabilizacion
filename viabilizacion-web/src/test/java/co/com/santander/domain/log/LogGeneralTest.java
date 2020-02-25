package co.com.santander.domain.log;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
