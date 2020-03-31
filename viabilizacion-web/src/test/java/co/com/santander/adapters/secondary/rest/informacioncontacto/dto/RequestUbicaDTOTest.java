package co.com.santander.adapters.secondary.rest.informacioncontacto.dto;

import co.com.santander.dto.reconocer.RequestUbicaDTO;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestUbicaDTOTest {

    @Test
    public void testObject() {
        Assert.assertThat(RequestUbicaDTO.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
