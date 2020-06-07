package co.com.santander.utils.impl;

import co.com.santander.utils.IGenerateUniqueId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class GenerateUniqueIdImplTest {

    private IGenerateUniqueId generateUniqueId;

    @Before
    public void setUp() {
        generateUniqueId = new GenerateUniqueIdImpl();
    }

    @Test
    public void testGenerateUniqueIdStr() {
        Assert.assertNotNull(generateUniqueId.generateUniqueIdStr(10L));
    }

}