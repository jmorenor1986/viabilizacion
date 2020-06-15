package co.com.santander.service;

import co.com.santander.clients.KeyCloakClient;
import co.com.santander.dto.keycloak.KeyCloakRequestDto;
import co.com.santander.dto.keycloak.ResponseKeyCloakDto;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Autowired
    private KeyCloakClient keyCloakClient;

    @Autowired
    private KeyCloakRequestDto keyCloakRequestDto;

    @Override
    public void apply(RequestTemplate template) {
        if (!template.url().contains("token")) {
            ResponseEntity<ResponseKeyCloakDto> result = keyCloakClient.getToken(keyCloakRequestDto);
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, result.getBody().getAccess_token()));
        }
    }
}
