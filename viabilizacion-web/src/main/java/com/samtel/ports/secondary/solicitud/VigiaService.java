package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ListaCliente;

public interface VigiaService {
    ListaCliente consultarListasCliente(Cliente datosBasicosCliente);
}
