package co.com.santander.clients;

import co.com.santander.dto.keycloak.KeyCloakRequestDto;
import co.com.santander.dto.keycloak.ResponseKeyCloakDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${keycloak.client.service-name}", url = "${keycloak.client.url}")
public interface KeyCloakClient {
    @RequestMapping(value = "/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseKeyCloakDto> getToken(KeyCloakRequestDto data);
}