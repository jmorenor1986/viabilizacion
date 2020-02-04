package com.samtel.adapters.secondary.database.solicitud;

import org.springframework.stereotype.Repository;

@Repository
public interface ValidarCiudadRepository {
    public Boolean validarCodigoCiudad(String codigo);
}
