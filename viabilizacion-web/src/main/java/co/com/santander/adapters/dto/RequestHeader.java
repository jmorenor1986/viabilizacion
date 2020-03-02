package co.com.santander.adapters.dto;

import lombok.Data;

@Data
public class RequestHeader {

    private String codAliado;
    private String usuarioAliado;
    private String sesionId;
    private String ipOrigen;
    private String numeroSolicitudCredito;
    private String tipoIdentificacion;
    private String identificacion;
}
