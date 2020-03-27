package co.com.santander.dto.dictum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class PrincipalRequestDictumDTO {

    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String valorSolicitado;
    private String ingresos;
    private String actividadEconomica;

}
