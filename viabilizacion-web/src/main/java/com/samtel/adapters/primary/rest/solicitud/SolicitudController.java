package com.samtel.adapters.primary.rest.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.primary.solicitud.SolicitudService;
import org.modelmapper.ModelMapper;

public class SolicitudController {

    private final SolicitudService solicitudService;
    private final ModelMapper modelMapper;

    public SolicitudController(SolicitudService solicitudService, ModelMapper modelMapper) {
        this.solicitudService = solicitudService;
        this.modelMapper = modelMapper;
    }

    public String solicitud(ClientePayLoad clientePayLoad) {
        return solicitudService.cumplimientoSolicitud(modelMapper.map(clientePayLoad, Cliente.class));
    }
}
