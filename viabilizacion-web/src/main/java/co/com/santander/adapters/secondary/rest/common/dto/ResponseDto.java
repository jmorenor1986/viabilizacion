package co.com.santander.adapters.secondary.rest.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
