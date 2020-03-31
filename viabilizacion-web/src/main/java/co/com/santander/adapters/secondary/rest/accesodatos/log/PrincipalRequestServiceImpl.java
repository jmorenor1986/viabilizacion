package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.clients.viabilizacion.PrincipalRequestClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.PrincipalRequestPayload;
import co.com.santander.ports.secondary.accesodatos.PrincipalRequestService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalRequestServiceImpl implements PrincipalRequestService {

    private final PrincipalRequestClient principalRequestClient;

    @Autowired
    public PrincipalRequestServiceImpl(PrincipalRequestClient principalRequestClient ) {
        this.principalRequestClient = principalRequestClient;
    }

    @Override
    public PrincipalRequestPayload insertaPrincipalRequest(GeneralPayload<PrincipalRequestPayload> principalRequest) {
        ResponseDto rta = principalRequestClient.insertaPrincipalRequest(principalRequest).getBody();
        return getObject(rta.getRespuestaServicio());
    }

    public  PrincipalRequestPayload getObject(String json){
        return new Gson().fromJson(json, PrincipalRequestPayload.class);
    }
}
