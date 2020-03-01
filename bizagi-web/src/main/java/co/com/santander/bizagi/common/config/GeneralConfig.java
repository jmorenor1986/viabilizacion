package co.com.santander.bizagi.common.config;

import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.common.properties.SystemProperties;
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
        setSystemProperty();
        return new WorkflowEngineSOA(new URL(serviciosProperties.getUriCrearCaso()));
    }

    private void setSystemProperty() {
        System.setProperty(SystemProperties.JAVAX_NET_DEBUG, SystemProperties.VALUE_JAVAX_NET_DEBUG);
        System.setProperty(SystemProperties.JAVAX_NET_SSL_TRUST_STORE, serviciosProperties.getTrustStore());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_TRUST_STORE_PASSWORD, serviciosProperties.getTrustStorePassword());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_KEY_STORE, serviciosProperties.getKeyStore());
        System.setProperty(SystemProperties.JAVAX_NET_SSL_KEY_STORE_PASSWORD, serviciosProperties.getKeyStorePassword());
        System.setProperty(SystemProperties.ORG_APACHE_CXF_STAX_ALLOW_INSECURE_PARSER, SystemProperties.VALUE_ALLOW_INSECURE_PARSER);
    }
}
