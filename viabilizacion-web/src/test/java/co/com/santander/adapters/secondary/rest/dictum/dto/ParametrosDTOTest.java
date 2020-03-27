package co.com.santander.adapters.secondary.rest.dictum.dto;

import co.com.santander.dto.dictum.ParametrosDTO;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParametrosDTOTest {

    @Test
    public void testObject() {
        Assert.assertNotNull(new ParametrosDTO());
        Assert.assertThat(ParametrosDTO.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
