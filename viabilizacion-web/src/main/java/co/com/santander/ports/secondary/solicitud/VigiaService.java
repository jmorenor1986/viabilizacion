package co.com.santander.ports.secondary.solicitud;

import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.domain.solicitud.ListaCliente;

public interface VigiaService {
    ListaCliente consultarListasCliente(Cliente datosBasicosCliente, String idRequest);
}
