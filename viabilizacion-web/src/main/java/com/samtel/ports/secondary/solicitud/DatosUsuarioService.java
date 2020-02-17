package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.datosusuario.RequestDatosUsuario;
import com.samtel.domain.solicitud.datosusuario.ResponseDatosUsuario;

public interface DatosUsuarioService {
    ResponseDatosUsuario consultarDatosUsuario(RequestDatosUsuario requestDatosUsuario);
}
