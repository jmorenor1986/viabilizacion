package co.com.santander.ports.secondary.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

public interface InformacionContactoService {
    ResponseInformacionContacto consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);

    ResponseInformacionContacto consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);
}
