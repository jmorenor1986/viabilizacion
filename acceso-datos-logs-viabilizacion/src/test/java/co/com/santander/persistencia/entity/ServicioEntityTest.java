package co.com.santander.persistencia.entity;

import co.com.santander.persistencia.common.ServicioEnum;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ServicioEntityTest {

    @Test
    public void testObject(){
        ServicioEntity servicio = ServicioEntity.builder()
                .descripcion("descripcion")
                .id(Long.valueOf("1"))
                .logs(new ArrayList<>())
                .vigencia(Long.valueOf("30"))
                .servicio(ServicioEnum.VALIDATE_CITY)
                .build();
        Assert.assertNotNull(servicio);
        servicio.addLog(LogEntity.builder().build());
        servicio.removeLog(LogEntity.builder().build());
        Assert.assertThat(ServicioEntity.class, CoreMatchers.allOf(
                BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidGettersAndSetters()
        ));
    }
}