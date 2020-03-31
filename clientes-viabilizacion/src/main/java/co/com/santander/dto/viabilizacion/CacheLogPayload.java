package co.com.santander.dto.viabilizacion;

import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class CacheLogPayload {
    private String cache;
    private String usuarioMicro;
    private FlowOperationEnum tipo;
    private String traza;
    private Date fecha;
    private ServicioPayload servicio;
    private HttpStatus httpStatus;
    private CachePayload cacheUsr;
    private String url;
    private PrincipalRequestPayload principalRequest;
}
