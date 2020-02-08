package com.samtel.domain;

import com.google.code.beanmatchers.BeanMatchers;
import com.samtel.domain.solicitud.RequestHeader;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestHeaderTest {
    @Test
    public void testObject() {
        Assert.assertNotNull(new RequestHeader());
        Assert.assertThat(RequestHeader.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
