package co.com.santander.validation.service;

import java.util.List;

import co.com.santander.validation.entity.Ciudad;

public interface CiudadService {
    Boolean validarCiudad(String nombreCiudad);
    List<Ciudad> traerCiudades();
}
