package co.com.santander.adapters.secondary.rest.accesodatos.payload;

import co.com.santander.core.common.EstadoEnum;
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
