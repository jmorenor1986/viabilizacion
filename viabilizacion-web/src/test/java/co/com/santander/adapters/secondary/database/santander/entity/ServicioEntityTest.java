package co.com.santander.adapters.secondary.database.santander.entity;

import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.entity.ServicioEntity;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServicioEntityTest {

	private LogEntity log;

	@Before
	public void setUp() {
		log = new LogEntity();
		log.setId(Long.valueOf("1"));
	}

	@Test
	public void testServicio() {
		ServicioEntity servicio = new ServicioEntity();
		servicio.hashCode();
		servicio.addLog(log);
		servicio.removeLog(log);
		Assert.assertNotNull(servicio.equals(new ServicioEntity()));
		Assert.assertNotNull(servicio.equals(servicio));
		Assert.assertNotNull(servicio);
		Assert.assertThat(ServicioEntity.class, CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters()));
	}
}
