package com.samtel.domain.solicitud;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaCliente {
    private String resultado;
    private String estado;
}
