package co.com.santander.feign.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "keycloak.client")
public class KeyCloakConfig {
    @JsonProperty("client-id")
    private String clientId;
    @JsonProperty("client-secret")
    private String clientSecret;
    @JsonProperty("grant-type")
    private String grantType;
    @JsonProperty("url")
    private String url;
}
