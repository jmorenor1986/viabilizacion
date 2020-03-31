package co.com.santander.ports.secondary.accesodatos;

import co.com.santander.dto.viabilizacion.ServicioPayload;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;

import java.util.Optional;

public interface ServicioService {

    Optional<ServicioPayload> findServiceByService(ServicioEnum servicio);

}
