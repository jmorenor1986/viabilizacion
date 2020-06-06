package co.com.santander.adapters.secondary.rest.access;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;

import java.util.Map;
import java.util.Optional;

public interface RestService {
    /**
     * Metodo encargado especificamente d
     * @param request
     * @return
     */
    Optional< ResponseDto > callService(GeneralPayload request, ServicioEnum servicio, Optional<Map<String, String>> cache);

}
