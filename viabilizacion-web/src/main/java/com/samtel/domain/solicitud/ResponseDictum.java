package com.samtel.domain.solicitud;

import lombok.Data;

@Data
public class ResponseDictum {
    private Integer codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
