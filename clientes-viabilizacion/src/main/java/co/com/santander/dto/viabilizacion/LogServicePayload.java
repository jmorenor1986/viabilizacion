package co.com.santander.dto.viabilizacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogServicePayload {
    private LogPayload log;
    private String idCache;
    private Long idServicio;

}
