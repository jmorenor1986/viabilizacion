package co.com.santander.config;

import feign.Logger;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import feign.codec.Encoder;



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

    @Bean
    Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }
}