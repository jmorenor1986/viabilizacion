package com.samtel.adapters.secondary.rest.impl;

import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import org.springframework.stereotype.Service;

@Service
public class ValidarCiudadServiceImpl implements ValidarCiudadService {


    @Override
    public Boolean validarCodigoCiudad(String codigoCiudad) {
        return false;
    }
}
