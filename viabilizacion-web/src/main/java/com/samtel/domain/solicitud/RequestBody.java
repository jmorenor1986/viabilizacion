package com.samtel.domain.solicitud;

import lombok.Data;

import java.util.List;

@Data
public class RequestBody {
    private String clave;
    private String identificacion;
    private String primerApellido;
    private String producto;
    private String tipoIdentificacion;
    private List<Parametros> parametros;

}
