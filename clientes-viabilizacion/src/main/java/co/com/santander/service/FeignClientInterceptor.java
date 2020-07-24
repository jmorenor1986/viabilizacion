package co.com.santander.service;

import co.com.santander.dto.keycloak.KeyCloakRequestDto;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Autowired
    private TokenService tokenService;

    @Autowired
    private KeyCloakRequestDto keyCloakRequestDto;
    @Value("${vaibilizacion.token-active}")
    private String activeToken;

    @Override
    public void apply(RequestTemplate template) {
        System.out.println(activeToken);
        if ( "true".equals(activeToken)  && !template.url().contains("token")) {
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, tokenService.getToken()));
        }
    }
}
