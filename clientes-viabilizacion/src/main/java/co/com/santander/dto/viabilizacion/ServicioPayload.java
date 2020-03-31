package co.com.santander.dto.viabilizacion;


import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
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
