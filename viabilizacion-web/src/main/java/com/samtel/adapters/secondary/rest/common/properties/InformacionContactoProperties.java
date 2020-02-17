package com.samtel.adapters.secondary.rest.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacionContactoProperties {
    private ReconocerProperties reconocerProperties;
    private UbicaProperties ubicaProperties;

}
