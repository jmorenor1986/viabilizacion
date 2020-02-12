package com.samtel.domain.solicitud.reconocer;

import lombok.Data;

import java.util.List;

@Data
public class ResponseReconocer {
    private List<String> numerosTelefono;
    private List<String> numerosCelular;
    private List<String> direcciones;
}
