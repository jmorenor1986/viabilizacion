package co.com.santander.bizagi.common.config;

import co.com.santander.bizagi.common.properties.ServiciosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tempuri.WorkflowEngineSOA;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class GeneralConfig {
    private final ServiciosProperties serviciosProperties;

    @Autowired
    public GeneralConfig(ServiciosProperties serviciosProperties) {
        this.serviciosProperties = serviciosProperties;
    }

    @Bean
    public WorkflowEngineSOA workflowEngineSOA() throws MalformedURLException {
        return new WorkflowEngineSOA(new URL(serviciosProperties.getUriCrearCaso()));
    }
}
