package viabilizacion.test.integration.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class IntegrationApplication extends SpringBootServletInitializer {
    public static void main(String... args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }
}