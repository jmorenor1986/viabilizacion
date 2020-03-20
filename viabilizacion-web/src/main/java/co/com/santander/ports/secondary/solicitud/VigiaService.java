package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;

public interface VigiaService {
    //Metodo principal de la interfaz
    ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest);

    JsonUtilities getJsonUtilities();

    default ListaCliente buscarRespuesta(String objeto){
        return ListaCliente.builder()
                .resultado(getJsonUtilities().getPropertyObjectWithKey("Data.", "Listas", objeto))
                .encontradoId(getJsonUtilities().getPropertyObjectWithKey("Data.", "EncontradoID", objeto))
                .encontradoNombre(getJsonUtilities().getPropertyObjectWithKey("Data.", "EncontradoNombre", objeto))
                .build();
    }
}
