package com.samtel.validation.service.impl;

import com.samtel.validation.entity.Ciudad;
import com.samtel.validation.service.CiudadRepository;
import com.samtel.validation.service.CiudadService;

public class CiudadServiceImpl implements CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Ciudad validarCiudad(String nombreCiudad) {
        return ciudadRepository.buscarPorCodigoONombre(nombreCiudad);
    }
}
