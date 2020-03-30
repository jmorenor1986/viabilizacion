package co.com.santander.persistencia.controller.payload.general;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePayLoad {
    private Long codRespuesta;
    private Object respuestaServicio;
    private String mensajeError;
}