package com.samtel.adapters.secondary.rest.validarciudad;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ValidarCiudadServiceImpl implements ValidarCiudadService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;

    @Autowired
    public ValidarCiudadServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = properties;
    }

    @Override
    public String validarCodigoCiudad(String codigoCiudad, String idRequest) {
        return restTemplateService.getWithPathParams(clientesProperties.getUriValidarCiudad(),
                new ArrayList<>(Arrays.asList(codigoCiudad)), generateHeaders(idRequest)).get();
    }

    public Optional<Map<String, String>> generateHeaders(String idRequest){
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest);
        return Optional.of(headers);
    }
}
