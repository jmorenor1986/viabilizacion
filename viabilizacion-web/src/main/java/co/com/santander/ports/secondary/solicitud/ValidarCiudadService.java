package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.validarciudad.dto.ValidarCiudad;

public interface ValidarCiudadService {

    String validarCodigoCiudad(GeneralPayload<ValidarCiudad> ciudad, Long idRequest);
}
