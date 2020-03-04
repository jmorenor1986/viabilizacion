package co.com.santander.core.domain.solicitud.informacioncontacto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacionContacto {
    private String numeroSolicitudCredito;
    private String tipoDocumento;
    private String numeroDocumento;
    private String codigoAliado;
    private String usuarioAliado;
    private String sessionId;
    private String ipOrigen;
    private String primerApellido;
    private String motivoConsulta;
}
