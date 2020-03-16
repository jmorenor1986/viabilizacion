package co.com.santander.adapters.secondary.rest.informacioncontacto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalReconocerDTO {

    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
