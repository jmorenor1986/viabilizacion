package co.com.santander.core.domain.solicitud.dictum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dictum {
    private String clave;
    private String primerApellido;
    private String producto;
    private String usuario;
    private List<Parametros> parametros;

}
