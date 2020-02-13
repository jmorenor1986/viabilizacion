package com.samtel.domain.solicitud.reconocer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseReconocer {
    private String numerosTelefono;
    private String numeroCelular;
    private List<String> direcciones;
}
