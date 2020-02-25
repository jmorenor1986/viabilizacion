package co.com.santander.domain.solicitud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListaCliente {
    private String resultado;
    private String encontradoId;
    private String encontradoNombre;
}
