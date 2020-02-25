package co.com.santander.adapters.secondary.rest.dictum.dto;

import lombok.Data;

@Data
public class ResponseDictumDTO {
    private Integer codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
