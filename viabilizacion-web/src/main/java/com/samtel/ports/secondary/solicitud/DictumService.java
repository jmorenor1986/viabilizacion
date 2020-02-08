package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.RequestDictum;

import java.util.Optional;

public interface DictumService {

    Optional<String> consultarSolicitudDictum(RequestDictum request);
}
