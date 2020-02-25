package co.com.santander.ports.secondary.solicitud;

import co.com.santander.domain.solicitud.dictum.RequestDictum;

import java.util.Optional;

public interface DictumService {

    Optional<String> consultarSolicitudDictum(RequestDictum request,String idRequest);
}
