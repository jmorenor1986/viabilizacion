package co.com.santander.adapters.secondary.rest.accesodatos.payload;

import co.com.santander.core.common.ServicioEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicioPayload {
    private Long id;
    private ServicioEnum servicio;
    private Long vigencia;
    private String descripcion;

}
