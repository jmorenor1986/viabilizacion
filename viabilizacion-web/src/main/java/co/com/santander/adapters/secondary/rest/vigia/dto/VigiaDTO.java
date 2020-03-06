package co.com.santander.adapters.secondary.rest.vigia.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VigiaDTO {
    private String nombre;
    private String porcentaje;
}
