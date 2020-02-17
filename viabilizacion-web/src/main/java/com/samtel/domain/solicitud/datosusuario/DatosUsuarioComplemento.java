package com.samtel.domain.solicitud.datosusuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DatosUsuarioComplemento extends RequestDatosUsuario {
    private String codigoInformacion;
    private String motivoConsulta;

}
