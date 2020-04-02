package co.com.santander.persistencia.controller.payload;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogServicePayloadTest {

    @Test
    public void testObject(){
        LogServicePayload logService = LogServicePayload.builder()
                .idCache("{}")
                .idServicio(Long.valueOf("123"))
                .log(LogPayload.builder().build())
                .build();
        Assert.assertNotNull(logService);
        Assert.assertNotNull(LogServicePayload.builder()
                .idCache("{}")
                .idServicio(Long.valueOf("123"))
                .log(LogPayload.builder().build()).toString());
        Assert.assertThat(LogServicePayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}