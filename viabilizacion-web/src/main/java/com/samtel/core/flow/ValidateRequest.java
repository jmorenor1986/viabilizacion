package com.samtel.core.flow;

import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

import java.util.Optional;

public interface ValidateRequest {

    Optional<ResponseFlow> process(Cliente cliente, String idRequest);
}
