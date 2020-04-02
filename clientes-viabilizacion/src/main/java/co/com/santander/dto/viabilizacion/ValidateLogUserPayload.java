package co.com.santander.dto.viabilizacion;

import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateLogUserPayload {
    private String cache;
    private Long vig;
    private FlowOperationEnum servicio;
}
