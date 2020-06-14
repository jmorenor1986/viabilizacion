package co.com.santander.feign.interceptor;

import co.com.santander.feign.client.KeyCloakClient;
import co.com.santander.feign.config.KeyCloakConfig;
import co.com.santander.feign.dto.ResponseKeyCloakDTO;
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
    private KeyCloakConfig keyCloakConfig;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ResponseEntity<ResponseKeyCloakDTO> keyCloakResult = keyCloakClient.getToken(keyCloakConfig);
        requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, keyCloakResult.getBody().getAccesToken()));
    }
}
