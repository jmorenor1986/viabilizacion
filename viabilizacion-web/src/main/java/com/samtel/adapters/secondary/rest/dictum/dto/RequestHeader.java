package com.samtel.adapters.secondary.rest.dictum.dto;

import lombok.Data;

@Data
public class RequestHeader {
    private String codAliado;
    private String usuarioAliado;
    private String sessionId;
    private String ipOrigen;
    private String numeroSolicitudCredito;
    private String tipoIdentificacion;
    private String identificacion;
}
