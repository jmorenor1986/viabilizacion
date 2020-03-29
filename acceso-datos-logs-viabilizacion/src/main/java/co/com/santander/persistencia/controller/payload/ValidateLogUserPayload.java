package co.com.santander.persistencia.controller.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateLogUserPayload {
    private String cache;
    private Long vig;
}
