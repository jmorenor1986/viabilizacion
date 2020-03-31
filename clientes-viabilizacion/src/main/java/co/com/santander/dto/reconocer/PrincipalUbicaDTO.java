package co.com.santander.dto.reconocer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalUbicaDTO {

    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
