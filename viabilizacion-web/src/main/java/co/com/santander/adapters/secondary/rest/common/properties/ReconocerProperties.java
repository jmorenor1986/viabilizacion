package co.com.santander.adapters.secondary.rest.common.properties;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReconocerProperties {
    private String uri;
    private String nit;
    private String tipoIdBuscar;
    private String numeroIdBuscar;
    private String validarNombre;
    private String uriToken;
}
