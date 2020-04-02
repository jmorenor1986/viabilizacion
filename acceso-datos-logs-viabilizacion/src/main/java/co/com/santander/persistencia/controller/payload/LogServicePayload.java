package co.com.santander.persistencia.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogServicePayload {
    private LogPayload log;
    private String idCache;
    private Long idServicio;

}
