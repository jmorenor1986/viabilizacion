package co.com.santander.adapters.secondary.rest.common.properties;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReconocerProperties {
    private String uri;
    private String nit;
    private String tipoIdBuscar;
    private String numeroIdBuscar;
    private String validarNombre;
    private String uriToken;
}
