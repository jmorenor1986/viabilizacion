package com.samtel.validation.service.impl;

import com.samtel.validation.common.BadRequestException;
import com.samtel.validation.entity.Ciudad;
import com.samtel.validation.service.CiudadRepository;
import com.samtel.validation.service.CiudadService;

import java.util.Objects;

public class CiudadServiceImpl implements CiudadService {
    public static final String ERROR_CIUDAD_INVALIDA = "LA CIUDAD INGRESADA NO EXISTE";
    public static final String ESTADO_CIUDAD_ACTIVO = "ACTIVO";
    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Boolean validarCiudad(String nombreCiudad) {
        Ciudad ciudad = ciudadRepository.buscarPorCodigoONombre(nombreCiudad);
        if (Objects.isNull(ciudad))
            throw new BadRequestException(ERROR_CIUDAD_INVALIDA);
        if (ciudad.getEstado().equals(ESTADO_CIUDAD_ACTIVO))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
