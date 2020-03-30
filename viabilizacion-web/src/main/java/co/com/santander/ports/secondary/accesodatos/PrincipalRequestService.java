package co.com.santander.ports.secondary.accesodatos;


import co.com.santander.adapters.secondary.rest.accesodatos.payload.PrincipalRequestPayload;

public interface PrincipalRequestService {

    PrincipalRequestPayload insertaPrincipalRequest(PrincipalRequestPayload principalRequest);
}
