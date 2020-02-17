package com.samtel.adapters.secondary.rest.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ReconocerProperties {
    private String uri;
    private String nit;
    private String tipoIdBuscar;
    private String numeroIdBuscar;
    private String validarNombre;
}
