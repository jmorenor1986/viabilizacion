package co.com.santander.adapters.secondary.database.santander.entity;

import co.com.santander.persistencia.entity.CacheUsrEntity;
import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheUsrEntityTest {

    @Test
    public void testLog() {
        Assert.assertNotNull(CacheUsrEntity.builder().build());
        Assert.assertThat(CacheUsrEntity.class, CoreMatchers.allOf(
                BeanMatchers.hasValidBeanConstructor(),
                BeanMatchers.hasValidBeanEquals(),
                BeanMatchers.hasValidBeanHashCode(),
                BeanMatchers.hasValidBeanToString(),
                BeanMatchers.hasValidGettersAndSetters()));
    }
}
