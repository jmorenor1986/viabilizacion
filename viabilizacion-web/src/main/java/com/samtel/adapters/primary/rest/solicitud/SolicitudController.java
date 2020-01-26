package com.samtel.adapters.primary.rest.solicitud;

import com.samtel.ports.primary.solicitud.SolicitudService;

public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    public String solicitud(ClientePayLoad clientePayLoad) {
        return solicitudService.cumplimientoSolicitud()
    }
}
