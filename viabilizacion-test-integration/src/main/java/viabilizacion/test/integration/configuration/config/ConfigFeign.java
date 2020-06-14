package viabilizacion.test.integration.configuration.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "viabilizacion.test.integration.configuration")
//@PropertySources({ @PropertySource("classpath:application-services.properties") })
public class ConfigFeign {

    public ConfigFeign() {
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}