package co.com.santander.dto.dictum;

import lombok.Data;

@Data
public class ResponseDictumDTO {
    private Integer codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
