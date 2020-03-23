package co.com.santander.bizagi.common.properties;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SystemPropertiesTest {
    @Test
    public void testObject() {
        Assert.assertThat(SystemProperties.class, CoreMatchers.allOf(BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanToString(), BeanMatchers.hasValidBeanEquals(), BeanMatchers.hasValidBeanHashCode()));
    }
}
