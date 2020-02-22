package com.samtel.adapters.secondary.rest.vigia.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalVigiaDTO {

    private String nombre;
    private String numeroIdentificacion;

}
