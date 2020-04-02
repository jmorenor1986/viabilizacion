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
public class LogPayloadTest {

    @Test
    public void testObject(){
        LogPayload logPayloas = LogPayload.builder()
                .id(Long.valueOf("1"))
                .fecha(new Date())
                .httpStatus(HttpStatus.OK)
                .idRequest(Long.valueOf("123"))
                .tipo(FlowOperationEnum.VALIDATE_CITY)
                .traza("{}")
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .usuarioMicro("jsierra")

                .build();
        Assert.assertNotNull(LogPayload.builder()
                .id(Long.valueOf("1"))
                .fecha(new Date())
                .httpStatus(HttpStatus.OK)
                .idRequest(Long.valueOf("123"))
                .tipo(FlowOperationEnum.VALIDATE_CITY)
                .traza("{}")
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .usuarioMicro("jsierra")
                .toString());

        Assert.assertThat(LogPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode()
                ));
    }
}