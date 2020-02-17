package com.samtel.domain.solicitud.reconocer;

import com.google.code.beanmatchers.BeanMatchers;
import com.samtel.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestInformacionContactoTest {

    @Test
    public void testRequestReconocer() {
        Assert.assertThat(RequestInformacionContacto.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}
