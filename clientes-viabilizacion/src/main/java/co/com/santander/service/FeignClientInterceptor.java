package co.com.santander.service;

import co.com.santander.dto.keycloak.KeyCloakRequestDto;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Autowired
    private TokenService tokenService;

    @Autowired
    private KeyCloakRequestDto keyCloakRequestDto;

    @Override
    public void apply(RequestTemplate template) {
        if (!template.url().contains("token")) {
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, tokenService.getToken()));
        }
    }
}
