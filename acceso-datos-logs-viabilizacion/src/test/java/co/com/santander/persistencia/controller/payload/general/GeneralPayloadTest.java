package co.com.santander.persistencia.controller.payload.general;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneralPayloadTest {

    @Test
    public void testObject(){
        GeneralPayload general = GeneralPayload.builder()
                .requestHeader(new RequestHeader())
                .build();
        Assert.assertNotNull(general);
        Assert.assertNotNull(GeneralPayload.builder()
                .requestHeader(new RequestHeader())
                .toString());
        Assert.assertThat(GeneralPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}