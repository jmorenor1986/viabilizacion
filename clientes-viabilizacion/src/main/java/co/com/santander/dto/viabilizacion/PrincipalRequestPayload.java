package co.com.santander.dto.viabilizacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalRequestPayload {
    private Long id;
    private String codigoAliado;
    private  String ipOrigen;
    private String usuarioAliado;
    private String json;

}
