package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.EstadoEnum;
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
