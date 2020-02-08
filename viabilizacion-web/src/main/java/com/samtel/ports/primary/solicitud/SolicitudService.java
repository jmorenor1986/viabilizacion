package com.samtel.ports.primary.solicitud;

import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

import java.util.Optional;

public interface SolicitudService {
	Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente);
}
