package com.samtel.adapters.secondary.database.solicitud;

import com.samtel.ports.secondary.solicitud.ValidarCiudadService;
import org.springframework.stereotype.Service;

@Service
public class ValidarCiudadServiceImpl implements ValidarCiudadService {
    private final ValidarCiudadRepository validarCiudadRepository;

    public ValidarCiudadServiceImpl(ValidarCiudadRepository validarCiudadRepository) {
        this.validarCiudadRepository = validarCiudadRepository;
    }

    @Override
    public Boolean validarCodigoCiudad(String codigoCiudad) {
        return validarCiudadRepository.validarCodigoCiudad(codigoCiudad);
    }
}
