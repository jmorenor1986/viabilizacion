package co.com.santander.ports.secondary.solicitud;

import co.com.santander.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import co.com.santander.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

public interface InformacionContactoService {
    ResponseInformacionContacto consultarDatosUsuario(RequestInformacionContacto requestInformacionContacto, String idRequest);

    ResponseInformacionContacto consultarInformacionContacto(RequestInformacionContacto requestInformacionContacto, String idRequest);
}
