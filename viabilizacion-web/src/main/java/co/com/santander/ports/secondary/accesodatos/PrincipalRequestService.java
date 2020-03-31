package co.com.santander.ports.secondary.accesodatos;


import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.viabilizacion.PrincipalRequestPayload;

public interface PrincipalRequestService {

    PrincipalRequestPayload insertaPrincipalRequest(GeneralPayload<PrincipalRequestPayload> principalRequest);
}
