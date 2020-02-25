package co.com.santander.ports.primary.solicitud;

import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;

import java.util.Optional;

public interface SolicitudService {
	Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente);
}
