package co.com.santander.config;

import co.com.santander.adapters.secondary.rest.common.HttpRequestInterceptor;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.core.services.log.LogService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@Configuration
public class GeneralConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public ClientHttpRequestFactory factory() {
        return new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    }

    @Bean
    public HttpRequestInterceptor getHttpInterceptor(LogService logService, FilterLogMapper filterLogMapper){
        return new HttpRequestInterceptor(logService, filterLogMapper);
    }
}
