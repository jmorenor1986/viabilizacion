package com.samtel.validation.service.impl;

import com.samtel.validation.entity.Ciudad;
import com.samtel.validation.service.CiudadRepository;
import com.samtel.validation.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CiudadServiceImpl implements CiudadService {
    public static final String ERROR_CIUDAD_INVALIDA = "LA CIUDAD INGRESADA NO EXISTE";
    public static final String ESTADO_CIUDAD_ACTIVO = "ACTIVO";
    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Boolean validarCiudad(String nombreCiudad) {
        Ciudad ciudad = ciudadRepository.buscarPorCodigoONombre(nombreCiudad);
        if ( Objects.isNull(ciudad) )
        	return Boolean.FALSE;
        else if(ciudad.getEstado().equals(ESTADO_CIUDAD_ACTIVO))
        	return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
