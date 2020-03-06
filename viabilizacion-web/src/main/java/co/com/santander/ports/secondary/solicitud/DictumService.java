package co.com.santander.ports.secondary.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;

import java.util.Optional;

public interface DictumService {

    Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest);
}
