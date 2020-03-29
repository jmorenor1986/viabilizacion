package co.com.santander.ports.secondary.accesodatos;

import co.com.santander.core.common.ServicioEnum;

import java.util.Optional;

public interface ServicioService {

    Optional<ServicioPayload> findServiceByService(ServicioEnum servicio);

}
