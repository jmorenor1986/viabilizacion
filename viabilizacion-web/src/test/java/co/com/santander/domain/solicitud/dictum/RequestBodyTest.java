package co.com.santander.domain.solicitud.dictum;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestBodyTest {
    @Test
    public void testObject(){
        Assert.assertNotNull(RequestBody.builder().build());
        Assert.assertThat(RequestBody.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanToString()));
    }
}
