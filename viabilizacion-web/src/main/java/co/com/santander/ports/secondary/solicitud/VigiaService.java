package co.com.santander.ports.secondary.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;

public interface VigiaService {
    ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest);
}
