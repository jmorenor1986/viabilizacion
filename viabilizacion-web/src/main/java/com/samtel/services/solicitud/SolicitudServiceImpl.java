package com.samtel.services.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.ports.primary.solicitud.SolicitudService;

import java.util.Optional;

public class SolicitudServiceImpl implements SolicitudService {
    private final ClienteValidator clienteValidator;

    public SolicitudServiceImpl(ClienteValidator clienteValidator) {
        this.clienteValidator = clienteValidator;
    }

    @Override
    public Optional<String> cumplimientoSolicitud(Cliente cliente) {
        if (clienteValidator.validateMandatory(cliente.getActividad()))
            return Optional.of("Validation Ok");
        return Optional.empty();
    }
}