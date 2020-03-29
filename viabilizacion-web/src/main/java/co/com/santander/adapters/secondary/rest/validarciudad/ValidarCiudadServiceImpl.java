package co.com.santander.adapters.secondary.rest.validarciudad;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.common.ServicioEnum;
import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ValidarCiudadServiceImpl extends ServiceRestAbs implements ValidarCiudadService {

    private final RestService restService;
    private final ClientesProperties clientesProperties;

    @Autowired
    public ValidarCiudadServiceImpl(@Qualifier("restServiceImpl") RestService restService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.restService = restService;
        this.clientesProperties = properties;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public String validarCodigoCiudad(GeneralPayload<ValidarCiudad> ciudad, Long idRequest) {
        Optional<Map<String, String>> headers = CreateHeadersMap.generateMap(HeaderDto.builder()
                .key("idRequest")
                .value(idRequest.toString())
                .build());
        Optional<ResponseDto> responseService = restService.callService(ciudad
                , ServicioEnum.VALIDATE_CITY
                , headers
        );
        return extractResult(responseService.isPresent() ? responseService.get().getRespuestaServicio() : "");
    }

    private String extractResult(String respuesta) {
        if ("".equalsIgnoreCase(respuesta)) {
            return "false";
        }
        return respuesta;
    }

}
