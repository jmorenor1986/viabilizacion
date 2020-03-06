package co.com.santander.adapters.secondary.rest.dictum.dto;

import co.com.santander.core.domain.solicitud.dictum.Parametros;
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
    private List<Parametros> parametros;
}
