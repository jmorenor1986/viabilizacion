package com.samtel.ports.primary.solicitud;

import com.samtel.domain.solicitud.Cliente;

import java.util.Optional;

public interface SolicitudService {
    Optional<String> cumplimientoSolicitud(Cliente cliente);
}
