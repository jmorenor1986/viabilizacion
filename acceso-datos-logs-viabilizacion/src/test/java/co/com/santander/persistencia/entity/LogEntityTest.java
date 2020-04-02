package co.com.santander.persistencia.entity;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

@SpringBootTest
public class LogEntityTest {

    @Test
    public void testObject() {
        LogEntity logEntity = LogEntity.builder()
                .id(Long.valueOf("1"))
                .fecha(new Date())
                .httpStatus(HttpStatus.OK)
                .traza("{}")
                .usuarioMicro("jsierra")
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .servicio(ServicioEntity.builder().build())
                .principalRequest(PrincipalRequest.builder().build())
                .cacheUsr(CacheUsrEntity.builder().build())
                .build();
        Assert.assertNotNull(logEntity);
        LogEntity.builder().build().hashCode();
        //Validamos prepersist
        logEntity.prePersistFunction();
        Assert.assertNotNull(logEntity.getFecha());
        Assert.assertThat(LogEntity.class, CoreMatchers.allOf(
                BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidGettersAndSetters()
        ));
    }
}