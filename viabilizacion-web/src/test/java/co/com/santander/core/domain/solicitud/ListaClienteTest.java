package co.com.santander.core.domain.solicitud;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListaClienteTest {

	@Test
	public void testListaClienteTest() {
		Assert.assertThat(ListaCliente.class, CoreMatchers.allOf(
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
	}
}
