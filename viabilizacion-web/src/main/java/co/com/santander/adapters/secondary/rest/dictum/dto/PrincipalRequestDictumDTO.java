package co.com.santander.adapters.secondary.rest.dictum.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PrincipalRequestDictumDTO {

    private String identificacion;
    private String primerApellido;
    private String tipoIdentificacion;

}
