package co.com.santander.dto.viabilizacion;

import co.com.santander.dto.viabilizacion.constants.EstadoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CachePayload {
    private Long id;
    private String paramBusq;
    private EstadoEnum estado;
    private String tipo;
}
