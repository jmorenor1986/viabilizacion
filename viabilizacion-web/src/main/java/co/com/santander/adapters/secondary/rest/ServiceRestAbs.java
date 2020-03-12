package co.com.santander.adapters.secondary.rest;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Optional;

public abstract class ServiceRestAbs {

    protected JsonUtilities jsonUtilities;

    protected ResponseDto extractGenericResponse(String json){
        return jsonUtilities.getGeneralResponse(json);
    }

    protected Optional<Map<String, String>> generateGenericsHeaders(Long idRequest, String objectCache){
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
}
