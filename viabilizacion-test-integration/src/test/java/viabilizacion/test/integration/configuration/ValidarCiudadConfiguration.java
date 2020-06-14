package viabilizacion.test.integration.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@TestPropertySource(locations = {"classpath:application-test.yml"})
public class ValidarCiudadConfiguration {
    private ConfigurableApplicationContext context;
    private String url;

    @PostConstruct
    public void runApplication() {
        this.context = new SpringApplicationBuilder(co.com.santander.ValidationApplication.class)
                .profiles("test")
                .run();
    }

    @PreDestroy
    public void stopApplication() {
        if (null != context)
            context.close();
    }
}
