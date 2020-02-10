package com.samtel.domain.solicitud;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestDictumTest {
    @Test
    public void testObject() {
        Assert.assertNotNull(new RequestDictum());
        Assert.assertThat(RequestDictum.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
