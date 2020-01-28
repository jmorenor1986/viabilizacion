package com.samtel.core.flow;

import com.samtel.domain.solicitud.RequestData;

import java.util.Optional;

public interface ValidateRequest {

    Optional<Boolean> process(RequestData data);
}
