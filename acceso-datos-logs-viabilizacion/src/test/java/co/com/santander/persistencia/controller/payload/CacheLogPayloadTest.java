package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.FlowOperationEnum;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

@SpringBootTest
public class CacheLogPayloadTest {
    @Test
    public void testObject(){
        Assert.assertNotNull(CacheLogPayload.builder()
                .fecha(new Date())
                .httpStatus(HttpStatus.OK)
                .traza("{\"requestHeader\"}")
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .tipo(FlowOperationEnum.VALIDATE_CITY)
                .usuarioMicro("jnsierra")
                .build().toString());
        Assert.assertThat(CacheLogPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}