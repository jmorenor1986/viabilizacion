package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.ServicioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioPayload {
    private Long id;
    private ServicioEnum servicio;
    private Long vigencia;
    private String descripcion;

}
