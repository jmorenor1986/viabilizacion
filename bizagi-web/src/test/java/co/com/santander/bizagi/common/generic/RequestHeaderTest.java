package co.com.santander.bizagi.common.generic;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestHeaderTest {

    @Test
    public void testObject() {
        RequestHeader header = RequestHeader.builder()
                .sesionId("123")
                .codAliado("001")
                .identificacion("1010")
                .ipOrigen("127.0.0.1")
                .numeroSolicitudCredito("123")
                .tipoIdentificacion("CC")
                .usuarioAliado("123")
                .build();
        Assert.assertNotNull(RequestHeader.builder()
                .sesionId("123")
                .codAliado("001")
                .identificacion("1010")
                .ipOrigen("127.0.0.1")
                .numeroSolicitudCredito("123")
                .tipoIdentificacion("CC")
                .usuarioAliado("123")
                .toString());
        Assert.assertThat(RequestHeader.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
