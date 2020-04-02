package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.common.ServicioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateLogUserPayload {
    private String cache;
    private Long vig;
    private FlowOperationEnum servicio;
}
