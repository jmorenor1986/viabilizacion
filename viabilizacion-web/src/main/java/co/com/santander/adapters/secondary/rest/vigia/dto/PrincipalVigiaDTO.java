package co.com.santander.adapters.secondary.rest.vigia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalVigiaDTO {

    private String nombre;
    private String numeroIdentificacion;

}
