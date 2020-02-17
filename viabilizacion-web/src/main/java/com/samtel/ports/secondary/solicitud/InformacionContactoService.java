package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.datosusuario.RequestInformacionContacto;
import com.samtel.domain.solicitud.datosusuario.ResponseInformacionContacto;

public interface InformacionContactoService {
    ResponseInformacionContacto consultarDatosUsuario(RequestInformacionContacto requestInformacionContacto);

    ResponseInformacionContacto consultarInformacionContacto(RequestInformacionContacto requestInformacionContacto);
}
