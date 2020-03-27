package co.com.santander.adapters.secondary.rest.access;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.constants.ServicioEnum;

import java.util.List;
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
