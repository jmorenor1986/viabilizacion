package co.com.santander.core.domain.solicitud.dictum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parametros {
    private String tipo;
    private String nombre;
    private String valor;
}
