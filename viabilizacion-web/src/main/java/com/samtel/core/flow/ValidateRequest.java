package com.samtel.core.flow;

import com.samtel.domain.solicitud.Cliente;

import java.util.Optional;

public interface ValidateRequest {

    Optional<Boolean> process(Cliente cliente);
}
