package viabilizacion.test.integration.configuration;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import viabilizacion.test.integration.configuration.builder.ValidarCiudadControllerFeignClientBuilder;
import viabilizacion.test.integration.configuration.client.ValidarCiudadClientTest;
import viabilizacion.test.integration.configuration.dto.GeneralPayloadTest;
import viabilizacion.test.integration.configuration.dto.RequestHeaderTest;
import viabilizacion.test.integration.configuration.dto.ResponseDtoTest;
import viabilizacion.test.integration.configuration.dto.ValidarCiudadTest;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValidarCiudadConfiguration.class})
@TestPropertySource(locations = {"classpath:application-test.yml"})
public class ValidarCiudadTestIT {

    private ValidarCiudadClientTest validarCiudadClientTest;


    @Before
    public void setUp() {
        ValidarCiudadControllerFeignClientBuilder feignClientBuilder = new ValidarCiudadControllerFeignClientBuilder();
        validarCiudadClientTest = feignClientBuilder.getValidarCiudadClientTest();
    }

    @Test
    public void testValidarCiudadTest() {
        GeneralPayloadTest<ValidarCiudadTest> request = GeneralPayloadTest.<ValidarCiudadTest>builder()
                .requestBody(ValidarCiudadTest.builder()
                        .ciudad("BOGOTA")
                        .build())
                .requestHeader(RequestHeaderTest.builder()
                        .codAliado("121")
                        .identificacion("12121212")
                        .build())
                .build();

        ResponseDtoTest result = validarCiudadClientTest.consultarCiudad(request);
        Assert.assertNotNull(result);
    }
}
