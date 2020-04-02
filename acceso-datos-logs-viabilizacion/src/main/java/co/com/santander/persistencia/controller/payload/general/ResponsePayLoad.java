package co.com.santander.persistencia.controller.payload.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePayLoad {
    private Long codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
