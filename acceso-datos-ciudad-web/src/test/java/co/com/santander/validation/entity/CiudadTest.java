package co.com.santander.validation.entity;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CiudadTest {
    @Test
    public void testCiudad() {
        Assert.assertNotNull(new Ciudad());
        Assert.assertThat(Ciudad.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
