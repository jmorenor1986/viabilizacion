package co.com.santander.adapters.secondary.rest.dictum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class PrincipalRequestDictumDTO {

    private String identificacion;
    private String primerApellido;
    private String tipoIdentificacion;

}
