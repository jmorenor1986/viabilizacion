package co.com.santander.adapters.secondary.rest.informacioncontacto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUbicaDTO {
    private String codigoInformacion;
    private String motivoConsulta;
    private String numeroIdentificacion;
    private String primerApellido;
    private String tipoIdentificacion;
}
