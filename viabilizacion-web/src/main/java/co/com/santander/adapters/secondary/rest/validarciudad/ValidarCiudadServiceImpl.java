package co.com.santander.adapters.secondary.rest.validarciudad;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.access.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.validarciudad.dto.ValidarCiudad;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ValidarCiudadServiceImpl implements ValidarCiudadService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;
    private final JsonUtilities jsonUtilities;

    @Autowired
    public ValidarCiudadServiceImpl(@Qualifier("proxyRestTemplateServiceImpl") RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = properties;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public String validarCodigoCiudad(GeneralPayload<ValidarCiudad> ciudad, Long idRequest) {
        Optional<Map<String, String>> headers = CreateHeadersMap.generateMap(HeaderDto.builder()
                .key("idRequest")
                .value(idRequest.toString())
                .build());
        Optional<String> responseService = restTemplateService.postWithOutParams(clientesProperties.getUriValidarCiudad()
                , ciudad
                , headers
        );
        return extractResult(responseService.isPresent() ? responseService.get() : "");
    }

    private String extractResult(String json) {
        if ("".equalsIgnoreCase(json)) {
            return "false";
        }
        String value = jsonUtilities.getValueForGivenKey("requestBody", "respuestaServicio", json);
        return value;
    }

}
