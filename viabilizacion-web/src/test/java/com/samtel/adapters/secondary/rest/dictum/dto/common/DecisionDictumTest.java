package com.samtel.adapters.secondary.rest.dictum.dto.common;

import com.google.code.beanmatchers.BeanMatchers;
import com.samtel.adapters.secondary.rest.dictum.common.DecisionDictum;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DecisionDictumTest {
    @Test
    public void testObject() {
        Assert.assertNotNull(new DecisionDictum());
        Assert.assertThat(DecisionDictum.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}
