package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CachePayload {
    private Long id;
    private String paramBusq;
    private EstadoEnum estado;
    private String tipo;
}
