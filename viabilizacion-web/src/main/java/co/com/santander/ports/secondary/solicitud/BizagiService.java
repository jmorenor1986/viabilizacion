package co.com.santander.ports.secondary.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;

import java.util.Optional;

public interface BizagiService {

    Optional<String> createCaseBizagi(Cliente cliente, Long idRequest);

}
