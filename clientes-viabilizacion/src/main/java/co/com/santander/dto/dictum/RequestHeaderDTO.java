package co.com.santander.dto.dictum;

import lombok.Data;

@Data
public class RequestHeaderDTO {
    private String codAliado;
    private String usuarioAliado;
    private String sessionId;
    private String ipOrigen;
    private String numeroSolicitudCredito;
    private String tipoIdentificacion;
    private String identificacion;
}
