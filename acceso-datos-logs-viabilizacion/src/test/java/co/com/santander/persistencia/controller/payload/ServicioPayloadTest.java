package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.ServicioEnum;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServicioPayloadTest {

    @Test
    public void testObject() {
        ServicioPayload servicioPayload = ServicioPayload.builder()
                .id(Long.valueOf("1"))
                .servicio(ServicioEnum.VALIDATE_CITY)
                .vigencia(Long.valueOf("30"))
                .descripcion("{}")
                .build();
        Assert.assertNotNull(servicioPayload);
        Assert.assertNotNull(ServicioPayload.builder()
                .id(Long.valueOf("1"))
                .servicio(ServicioEnum.VALIDATE_CITY)
                .vigencia(Long.valueOf("30"))
                .descripcion("{}")
                .toString());
        Assert.assertThat(ServicioPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}