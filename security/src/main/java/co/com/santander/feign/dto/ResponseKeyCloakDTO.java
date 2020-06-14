package co.com.santander.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseKeyCloakDTO {
    @JsonProperty("access_token")
    private String accesToken;
}
