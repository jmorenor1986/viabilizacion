package co.com.santander.dto.keycloak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "keycloak.client")
public class KeyCloakRequestDto {
    @JsonProperty("client-id")
    private String clientId;
    @JsonProperty("client-secret")
    private String clientSecret;
    @JsonProperty("grant-type")
    private String grantType;
    @JsonProperty("url")
    private String url;

    public Map<String, String> getParams(){
        Map<String, String> parametros = new HashMap<>();
        parametros.put("client_secret",getClientSecret());
        parametros.put("grant_type",getGrantType());
        parametros.put("client_id",getClientId());
        return parametros;
    }
}
