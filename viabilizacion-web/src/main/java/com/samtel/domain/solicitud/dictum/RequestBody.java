package com.samtel.domain.solicitud.dictum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestBody {
    private String clave;
    private String identificacion;
    private String primerApellido;
    private String producto;
    private String tipoIdentificacion;
    private List<Parametros> parametros;

}
