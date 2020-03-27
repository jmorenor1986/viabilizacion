package co.com.santander.config;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@XSlf4j
@Configuration
@EnableFeignClients(basePackages = "co.com.santander.clients")
//@PropertySources({ @PropertySource("classpath:application-services.properties") })
public class ConfigFeign {

    public ConfigFeign() {
        log.entry(ConfigFeign.class.getName());
    }
}