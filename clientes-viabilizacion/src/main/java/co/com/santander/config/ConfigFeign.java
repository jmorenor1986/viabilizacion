package co.com.santander.config;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@XSlf4j
@Configuration
@EnableFeignClients(basePackages = "co.com.santander.serviciosexternos.client")
public class ConfigFeign {

    public ConfigFeign() {
        log.entry(ConfigFeign.class.getName());
    }
}