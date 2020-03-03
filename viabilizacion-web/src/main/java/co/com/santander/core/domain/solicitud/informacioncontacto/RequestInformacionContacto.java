package co.com.santander.core.domain.solicitud.informacioncontacto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class RequestInformacionContacto {
    private String motivoConsulta;
    private String primerApellido;
}
