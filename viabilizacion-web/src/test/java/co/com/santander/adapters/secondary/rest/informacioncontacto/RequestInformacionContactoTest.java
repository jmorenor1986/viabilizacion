package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.core.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestInformacionContactoTest {
    @Test
    public void testObject() {
        Assert.assertThat(RequestInformacionContacto.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
