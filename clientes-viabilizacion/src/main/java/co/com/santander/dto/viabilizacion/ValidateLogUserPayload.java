package co.com.santander.dto.viabilizacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateLogUserPayload {
    private String cache;
    private Long vig;
}
