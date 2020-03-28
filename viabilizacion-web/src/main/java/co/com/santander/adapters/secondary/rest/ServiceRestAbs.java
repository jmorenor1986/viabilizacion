package co.com.santander.adapters.secondary.rest;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.service.CacheUsrService;
import co.com.santander.persistencia.service.ServicioService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ServiceRestAbs {
    @Getter
    protected JsonUtilities jsonUtilities;
    protected ServicioService servicioService;
    protected CacheUsrService cacheUsrService;
    @Getter
    @Setter
    private String keyCache;
    @Getter
    @Setter
    private Long vigencia;


    protected ResponseDto extractGenericResponse(String json) {
        return jsonUtilities.getGeneralResponse(json);
    }

    protected Optional<Map<String, String>> generateGenericsHeaders(Long idRequest, String objectCache) {
        return CreateHeadersMap.generateMap(HeaderDto
                        .builder()
                        .key("idRequest")
                        .value(idRequest.toString())
                        .build(),
                HeaderDto
                        .builder()
                        .key("idCache")
                        .value(objectCache)
                        .build());
    }


    public Optional<Map<String, String>> generateBasicHeaders(Long idRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest.toString());
        return Optional.of(headers);
    }

    protected Boolean consultaCacheServicio(ServicioEnum servicioEnum) {
        //Obetenemos el objeto con el cual se va ha validar el cache
        Optional<ServicioEntity> servicio = servicioService.findServiceByService(servicioEnum);
        if (servicio.isPresent()) {
            //Valido si el tiempo es superior a 0
            setVigencia(servicio.get().getVigencia());
            if (getVigencia().compareTo(Long.valueOf(0)) > 0) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    protected Optional<String> obtenerValorCache() {
        Optional<String> traza = cacheUsrService.validityLogUser(getKeyCache(), getVigencia());
        if (traza.isPresent()) {
            return Optional.of(traza.get());
        }
        return Optional.empty();
    }


}
