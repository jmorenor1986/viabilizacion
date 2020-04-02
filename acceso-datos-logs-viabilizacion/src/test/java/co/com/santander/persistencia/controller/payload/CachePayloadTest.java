package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.EstadoEnum;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CachePayloadTest {

    @Test
    public void testObject(){
        Assert.assertNotNull(CachePayload.builder()
                .estado(EstadoEnum.ACTIVO)
                .id(Long.valueOf("1"))
                .paramBusq("{}")
                .tipo("REQUEST")
                .build());

        Assert.assertThat(CachePayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}