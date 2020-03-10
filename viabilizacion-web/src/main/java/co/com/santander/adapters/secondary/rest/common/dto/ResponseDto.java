package co.com.santander.adapters.secondary.rest.common.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
