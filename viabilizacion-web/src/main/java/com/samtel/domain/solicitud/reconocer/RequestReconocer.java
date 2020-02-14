package com.samtel.domain.solicitud.reconocer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestReconocer {
    private String primerApellido;
    private String tipoDocumento;
    private String numeroDocumento;
}
