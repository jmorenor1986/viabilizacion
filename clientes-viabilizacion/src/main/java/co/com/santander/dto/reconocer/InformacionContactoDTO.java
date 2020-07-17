package co.com.santander.dto.reconocer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacionContactoDTO {
    private String primerApellidoBuscar;
    private String validarNombre;
    private String motivoConsulta;
    private String token;
}
