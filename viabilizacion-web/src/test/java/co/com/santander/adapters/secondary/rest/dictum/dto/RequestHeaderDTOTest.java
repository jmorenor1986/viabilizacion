package co.com.santander.adapters.secondary.rest.dictum.dto;

import co.com.santander.dto.dictum.RequestHeaderDTO;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestHeaderDTOTest {

    @Test
    public void testObject() {
        Assert.assertNotNull(new RequestHeaderDTO());
        Assert.assertThat(RequestHeaderDTO.class, CoreMatchers.allOf(BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidGettersAndSetters(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString()));
    }
}
