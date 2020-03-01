package co.com.santander.core.domain.solicitud.informacioncontacto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseInformacionContacto {
    private List<String> numerosTelefono;
    private List<String> numeroCelular;
    private List<String> direcciones;
    private boolean tieneDatos;
}
