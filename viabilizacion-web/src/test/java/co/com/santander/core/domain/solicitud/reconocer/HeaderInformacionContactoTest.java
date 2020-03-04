package co.com.santander.core.domain.solicitud.reconocer;

import com.google.code.beanmatchers.BeanMatchers;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeaderInformacionContactoTest {

    @Test
    public void testRequestReconocer() {
        Assert.assertThat(InformacionContacto.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}
