package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;

public interface VigiaService {
    /**
     * Metodo encargado de retornar el objeto solicitado por vigia
     * @param datosBasicosCliente
     * @param idRequest
     * @return
     */
    ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest);

    JsonUtilities getJsonUtilities();

    default ListaCliente buscarRespuesta(String respuestaServicio){
        return ListaCliente.builder()
                .resultado(getJsonUtilities().getPropertyObjectWithKey("Data.", "Listas", respuestaServicio))
                .encontradoId(getJsonUtilities().getPropertyObjectWithKey("Data.", "EncontradoID", respuestaServicio))
                .encontradoNombre(getJsonUtilities().getPropertyObjectWithKey("Data.", "EncontradoNombre", respuestaServicio))
                .build();
    }
}
