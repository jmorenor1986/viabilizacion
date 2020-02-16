package com.samtel.domain.solicitud.reconocer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReconocer {
    private String numerosTelefono;
    private String numeroCelular;
    private List<String> direcciones;
}
