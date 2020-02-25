package co.com.santander.adapters.secondary.rest.dictum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyDTO {
    private String clave;
    private String identificacion;
    private String primerApellido;
    private String producto;
    private String tipoIdentificacion;
    private List<ParametrosDTO> parametros;

}
