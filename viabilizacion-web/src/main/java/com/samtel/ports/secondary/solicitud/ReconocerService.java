package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.reconocer.RequestReconocer;
import com.samtel.domain.solicitud.reconocer.ResponseReconocer;

public interface ReconocerService {
    ResponseReconocer consultarDatosUsuario(RequestReconocer requestReconocer);
}
