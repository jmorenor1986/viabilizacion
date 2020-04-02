package co.com.santander.persistencia.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalRequestPayload {
    private Long id;
    private String codigoAliado;
    private  String ipOrigen;
    private String usuarioAliado;
    private String json;

}
