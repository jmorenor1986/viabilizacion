package com.samtel.adapters.primary.rest.solicitud;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClientePayloadTest {
    @Test
    public void testClientPayLoad_Parameters() {
        Assert.assertNotNull(new ClientePayLoad());
        Assert.assertThat(ClientePayLoad.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
