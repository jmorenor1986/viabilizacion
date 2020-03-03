package co.com.santander.core.domain.solicitud.dictum;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class RequestHeaderDictum {
    @Value("${servicios.dictumProperties.codAliado}")
    private String codAliado;
    @Value("${servicios.dictumProperties.usuarioAliado}")
    private String usuarioAliado;
    @Value("${servicios.dictumProperties.sessionId}")
    private String sessionId;
    @Value("${servicios.dictumProperties.ipOrigen}")
    private String ipOrigen;
    @Value("${servicios.dictumProperties.numeroSolicitudCredito}")
    private String numeroSolicitudCredito;
    @Value("${servicios.dictumProperties.tipoIdentificacion}")
    private String tipoIdentificacion;
    @Value("${servicios.dictumProperties.identificacion}")
    private String identificacion;
}
