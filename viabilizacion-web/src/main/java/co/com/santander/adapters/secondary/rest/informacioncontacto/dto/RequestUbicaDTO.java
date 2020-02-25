package co.com.santander.adapters.secondary.rest.informacioncontacto.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestUbicaDTO {
    private String codigoInformacion;
    private String motivoConsulta;
    private String numeroIdentificacion;
    private String primerApellido;
    private String tipoIdentificacion;
}
