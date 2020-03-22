package co.com.santander.validation.dto;

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
