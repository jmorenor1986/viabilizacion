package com.samtel.adapters.secondary.rest.common.properties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VigiaProperties {
    private String uriVigia;
    private String codigoEjecucion;
    private String origen;
    private String porcentaje;
}
