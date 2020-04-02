package co.com.santander.persistencia.entity;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PrincipalRequestTest {

    @Test
    public void testObject(){
        PrincipalRequest principal = PrincipalRequest.builder()
                .id(Long.valueOf("1"))
                .codigoAliado("001")
                .ipOrigen("127.0.0.1")
                .json("{}")
                .logs(new ArrayList<>())
                .usuarioAliado("admin")
                .build();
        Assert.assertNotNull(principal);
        principal.addLog(LogEntity.builder().build());
        principal.removeLog(LogEntity.builder().build());
        Assert.assertThat(PrincipalRequest.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidGettersAndSetters()
        ));
    }

}