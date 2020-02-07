package com.samtel.adapters.secondary.rest.dictum.dto;

import lombok.Data;

@Data
public class ResponseDictum {
    private Integer codRespuesta;
    private String respuestaServicio;
    private String mensajeError;
}
