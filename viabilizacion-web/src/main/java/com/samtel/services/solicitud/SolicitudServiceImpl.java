package com.samtel.services.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.errors.MandatoryFieldException;
import com.samtel.ports.primary.solicitud.SolicitudService;

import java.util.Optional;

public class SolicitudServiceImpl implements SolicitudService {
    private final ClienteValidator clienteValidator;

    public SolicitudServiceImpl(ClienteValidator clienteValidator) {
        this.clienteValidator = clienteValidator;
    }

    @Override
    public Optional<String> cumplimientoSolicitud(Cliente cliente) {
        if (clienteValidator.validateObject(cliente))
            return Optional.of("Validation Ok");
        throw new MandatoryFieldException("Request invalido", 400);
    }
}