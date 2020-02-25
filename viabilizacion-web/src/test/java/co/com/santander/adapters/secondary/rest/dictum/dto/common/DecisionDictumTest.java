package co.com.santander.adapters.secondary.rest.dictum.dto.common;

import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import com.google.code.beanmatchers.BeanMatchers;
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
