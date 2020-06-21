package co.com.santander.validation.service;

import co.com.santander.validation.entity.Ciudad;

import java.util.List;

public interface CiudadService {
    Boolean validarCiudad(String nombreCiudad);
    List<Ciudad> traerCiudades();
}
