package co.com.santander.bizagi.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "servicios")
@Getter
@Setter
public class ServiciosProperties {
    private String uriCrearCaso;
    private String trustStore;
    private String trustStorePassword;
    private String keyStore;
    private String keyStorePassword;
}
