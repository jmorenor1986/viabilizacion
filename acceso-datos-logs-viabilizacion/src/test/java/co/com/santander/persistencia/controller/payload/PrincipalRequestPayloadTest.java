package co.com.santander.persistencia.controller.payload;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrincipalRequestPayloadTest {

    @Test
    public void testObject(){
        Assert.assertNotNull(PrincipalRequestPayload.builder()
                .codigoAliado("001")
                .id(Long.valueOf("01"))
                .ipOrigen("127.0.0.1")
                .json("{}")
                .usuarioAliado("jsierra")
                .build());

        Assert.assertThat(PrincipalRequestPayload.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}