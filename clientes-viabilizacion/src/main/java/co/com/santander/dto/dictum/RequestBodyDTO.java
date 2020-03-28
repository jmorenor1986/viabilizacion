package co.com.santander.dto.dictum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyDTO {
    private String clave;
    private String primerApellido;
    private String producto;
    private String usuario;
    private List<ParametrosDTO> parametros;

}
