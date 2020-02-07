package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.RequestDictum;
import com.samtel.domain.solicitud.ResponseDictum;

import java.util.Optional;

public interface DictumService {
    Optional<ResponseDictum> consultarDictum(RequestDictum request);
}
