package com.samtel.adapters.secondary.rest.vigia.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensajeDTO {
    private String nombre;
    private String numeroIdentificacion;
    private String origen;
    private String porcentaje;
}
