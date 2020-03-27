package co.com.santander.adapters.secondary.rest.dictum.dto;

import co.com.santander.dto.dictum.RequestBodyDTO;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RequestBodyDTOTest {
	
	@Test
	public void testObject() {
		RequestBodyDTO request = new RequestBodyDTO();
		Assert.assertNotNull(request);
		Assert.assertNotNull(request.equals(new RequestBodyDTO()));
		Assert.assertNotNull(request.hashCode());
		Assert.assertThat(RequestBodyDTO.class, CoreMatchers.allOf(
                BeanMatchers.hasValidBeanToString()));
	}
}
