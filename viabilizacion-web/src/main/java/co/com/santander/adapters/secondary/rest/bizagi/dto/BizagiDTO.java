package co.com.santander.adapters.secondary.rest.bizagi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BizagiDTO {

    private String tipodeidentificacion;
    private String numeroIdentificacion;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;

}
