package co.com.santander.persistencia.controller.payload.general;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.controller.payload.CacheLogPayload;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneralPayloadTest {

    @Test
    public void testObject(){
        Assert.assertThat(GeneralPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}