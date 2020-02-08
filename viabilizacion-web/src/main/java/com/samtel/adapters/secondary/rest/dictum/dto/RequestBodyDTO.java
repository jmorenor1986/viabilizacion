package com.samtel.adapters.secondary.rest.dictum.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestBodyDTO {
    private String clave;
    private String identificacion;
    private String primerApellido;
    private String producto;
    private String tipoIdentificacion;
    private List<ParametrosDTO> parametros;

}
