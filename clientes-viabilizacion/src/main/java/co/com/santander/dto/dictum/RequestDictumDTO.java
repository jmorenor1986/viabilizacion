package co.com.santander.dto.dictum;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestDictumDTO {
    private String clave;
    private String primerApellido;
    private String producto;
    private String usuario;
    private List<ParametrosDTO> parametros;
}
