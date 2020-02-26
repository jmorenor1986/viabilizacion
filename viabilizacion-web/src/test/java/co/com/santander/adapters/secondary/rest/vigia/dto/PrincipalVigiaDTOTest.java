package co.com.santander.adapters.secondary.rest.vigia.dto;

import co.com.santander.adapters.secondary.rest.dictum.dto.ParametrosDTO;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrincipalVigiaDTOTest {
    @Test
    public void testObject(){
        Assert.assertThat(PrincipalVigiaDTO.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
