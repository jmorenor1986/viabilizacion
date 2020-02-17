package com.samtel.domain.solicitud.datosusuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDatosUsuario {
    private String primerApellido;
    private String tipoDocumento;
    private String numeroDocumento;
}
