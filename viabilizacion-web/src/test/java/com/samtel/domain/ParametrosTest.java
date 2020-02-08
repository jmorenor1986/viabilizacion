package com.samtel.domain;

import com.google.code.beanmatchers.BeanMatchers;
import com.samtel.domain.solicitud.Parametros;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParametrosTest {
    @Test
    public void testObject() {
        Assert.assertNotNull(new Parametros());
        Assert.assertThat(Parametros.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}