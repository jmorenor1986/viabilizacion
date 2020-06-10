package co.com.santander.ports.primary;

import co.com.santander.dto.viabilizacion.constants.ServicioEnum;

import java.util.Optional;

public interface FindUrlService {

    Optional<String> getUrlFrom(ServicioEnum servicio);

}
