package co.com.santander.core.domain.solicitud;

import com.google.code.beanmatchers.BeanMatchers;
import co.com.santander.core.domain.solicitud.dictum.RequestDictum;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestDictumTest {
    @Test
    public void testObject() {
        Assert.assertNotNull(RequestDictum.builder().build());
        Assert.assertThat(RequestDictum.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
