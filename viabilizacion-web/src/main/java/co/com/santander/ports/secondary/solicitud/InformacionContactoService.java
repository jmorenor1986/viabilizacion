package co.com.santander.ports.secondary.solicitud;

import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

public interface InformacionContactoService {
    ResponseInformacionContacto consultarDatosUsuario(InformacionContacto informacionContacto, String idRequest);

    ResponseInformacionContacto consultarInformacionContacto(InformacionContacto informacionContacto, String idRequest);
}
