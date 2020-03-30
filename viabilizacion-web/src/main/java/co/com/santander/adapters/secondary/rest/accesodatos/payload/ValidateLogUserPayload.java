package co.com.santander.adapters.secondary.rest.accesodatos.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateLogUserPayload {
    private String cache;
    private Long vig;
}
