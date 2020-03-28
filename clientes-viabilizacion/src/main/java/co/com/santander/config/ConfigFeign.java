package co.com.santander.config;

import feign.Logger;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@XSlf4j
@Configuration
@EnableFeignClients(basePackages = "co.com.santander.clients")
//@PropertySources({ @PropertySource("classpath:application-services.properties") })
public class ConfigFeign {

    public ConfigFeign() {
        log.entry(ConfigFeign.class.getName());
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}