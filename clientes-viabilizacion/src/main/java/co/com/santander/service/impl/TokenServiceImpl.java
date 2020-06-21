package co.com.santander.service.impl;

import co.com.santander.dto.keycloak.KeyCloakRequestDto;
import co.com.santander.dto.keycloak.ResponseKeyCloakDto;
import co.com.santander.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenServiceImpl implements TokenService {

    private final KeyCloakRequestDto keyCloakRequestDto;
    private final RestTemplate restTemplate;
    private final String urlLogin;

    @Autowired
    public TokenServiceImpl(
                            KeyCloakRequestDto keyCloakRequestDto,
                            RestTemplate restTemplate,
                            @Value("${keycloak.client.url}") String urlLogin) {
        this.keyCloakRequestDto = keyCloakRequestDto;
        this.restTemplate = restTemplate;
        this.urlLogin = urlLogin;
    }

    @Override
    public String getToken() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> request = keyCloakRequestDto.getParams();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(request, requestHeaders);
        ResponseEntity<ResponseKeyCloakDto> result = restTemplate.exchange(urlLogin ,HttpMethod.POST, requestEntity, ResponseKeyCloakDto.class);
        return result.getBody().getAccess_token();
    }
}
