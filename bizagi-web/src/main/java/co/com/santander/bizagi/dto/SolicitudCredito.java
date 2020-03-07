package co.com.santander.bizagi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SolicitudCredito {
    private Cliente cliente;
    private String AutorizaConsultaaCentrales;
}
