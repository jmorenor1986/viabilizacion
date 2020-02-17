package com.samtel.adapters.secondary.rest.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReconocerProperties {
    private String uri;
    private String nit;
    private String tipoIdBuscar;
    private String numeroIdBuscar;
    private String validarNombre;
}
