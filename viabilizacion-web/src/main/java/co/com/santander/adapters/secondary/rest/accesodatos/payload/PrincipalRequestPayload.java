package co.com.santander.adapters.secondary.rest.accesodatos.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalRequestPayload {
    private Long id;
    private String json;
    private String codigoAliado;
    private String usuarioAliado;
    private String ipOrigen;
}
