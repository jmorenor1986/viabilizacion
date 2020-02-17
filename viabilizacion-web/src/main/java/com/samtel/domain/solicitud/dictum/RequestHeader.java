package com.samtel.domain.solicitud.dictum;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
@ConfigurationProperties(prefix="servicios")
public class RequestHeader {

    private String codAliado;
    private String usuarioAliado;
    private String sessionId;
    private String ipOrigen;
    private String numeroSolicitudCredito;
    private String tipoIdentificacion;
    private String identificacion;
}
