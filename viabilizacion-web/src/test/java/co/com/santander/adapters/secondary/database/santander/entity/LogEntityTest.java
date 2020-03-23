package co.com.santander.adapters.secondary.database.santander.entity;

import co.com.santander.persistencia.entity.LogEntity;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogEntityTest {
	
	@Test
	public void testLog() {
		LogEntity log = new LogEntity();
		log.prePersistFunction();
		log.hashCode();
		Assert.assertNotNull(log.equals(new LogEntity()));
		Assert.assertNotNull(log.equals(log));
		Assert.assertNotNull(log);
		Assert.assertNotNull(LogEntity.builder().build());
		Assert.assertThat(LogEntity.class, CoreMatchers.allOf(
				BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidGettersAndSetters()));
		
	}
}
