package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.reconocer.RequestReconocer;

public interface ReconocerService {
    Object consultarDatosUsuario(RequestReconocer requestReconocer);
}
