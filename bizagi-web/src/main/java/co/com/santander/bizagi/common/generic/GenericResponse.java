package co.com.santander.bizagi.common.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
    private String codRespuesta;
    private Object respuestaServicio;
    private String respuestaError;
}
