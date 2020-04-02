package co.com.santander.persistencia.controller.payload.general;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestHeaderTest {

    @Test
    public void testObject(){
        RequestHeader request = RequestHeader.builder()
                .codAliado("001")
                .identificacion("123")
                .ipOrigen("127.0.0.1")
                .numeroSolicitudCredito("1234")
                .sesionId("1234")
                .tipoIdentificacion("CC")
                .usuarioAliado("pepito")
                .build();

        Assert.assertNotNull(request);
        Assert.assertNotNull(RequestHeader.builder()
                .codAliado("001")
                .identificacion("123")
                .ipOrigen("127.0.0.1")
                .numeroSolicitudCredito("1234")
                .sesionId("1234")
                .tipoIdentificacion("CC")
                .usuarioAliado("pepito").toString());
        Assert.assertThat(RequestHeader.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }

}