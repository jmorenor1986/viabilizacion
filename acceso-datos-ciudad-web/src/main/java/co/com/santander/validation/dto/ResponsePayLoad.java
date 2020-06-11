package co.com.santander.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePayLoad<T> {

    private Long codRespuesta;
    private T respuestaServicio;
    private String mensajeError;

}
