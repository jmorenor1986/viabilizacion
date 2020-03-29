package co.com.santander.persistencia.controller.cacheusr.payload;

import co.com.santander.persistencia.common.ServicioEnum;
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
