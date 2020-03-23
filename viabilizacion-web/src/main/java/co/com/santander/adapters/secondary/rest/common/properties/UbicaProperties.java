package co.com.santander.adapters.secondary.rest.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UbicaProperties {
    private String uri;
    private String codigoInformacion;
    private String motivoConsulta;
}
