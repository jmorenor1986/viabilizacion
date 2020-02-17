package com.samtel.domain.solicitud.informacioncontacto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestInformacionContacto {
    private String primerApellido;
    private String tipoDocumento;
    private String numeroDocumento;
}
