package co.com.santander.adapters.secondary.rest.informacioncontacto.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacionContactoDTO {
    private String primerApellidoBuscar;
    private String validarNombre;
    private String token;
}
