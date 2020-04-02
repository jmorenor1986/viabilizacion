package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.FlowOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
