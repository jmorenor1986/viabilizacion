package com.samtel.adapters.secondary.rest.validarciudad;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.config.ClientesProperties;
import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

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
    public String validarCodigoCiudad(String codigoCiudad) {
        return restTemplateService.getWithPathParams(clientesProperties.getUriValidarCiudad(),
                new ArrayList<>(Arrays.asList(codigoCiudad))).get();
    }
}
