package co.com.santander.ports.secondary.solicitud;

import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;

public interface ValidarCiudadService {

    String validarCodigoCiudad(GeneralPayload<ValidarCiudad> ciudad, Long idRequest);
}
