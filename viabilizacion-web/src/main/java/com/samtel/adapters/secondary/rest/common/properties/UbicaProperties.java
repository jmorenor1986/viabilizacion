package com.samtel.adapters.secondary.rest.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UbicaProperties {
    private String uri;
    private String codigoInformacion;
    private String motivoConsulta;
}
