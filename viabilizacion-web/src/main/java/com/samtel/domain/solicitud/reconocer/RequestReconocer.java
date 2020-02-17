package com.samtel.domain.solicitud.reconocer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReconocer {
    private String primerApellido;
    private String tipoDocumento;
    private String numeroDocumento;
}
