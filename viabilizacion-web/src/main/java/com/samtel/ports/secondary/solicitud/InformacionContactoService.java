package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import com.samtel.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

public interface InformacionContactoService {
    ResponseInformacionContacto consultarDatosUsuario(RequestInformacionContacto requestInformacionContacto, String idRequest);

    ResponseInformacionContacto consultarInformacionContacto(RequestInformacionContacto requestInformacionContacto, String idRequest);
}
