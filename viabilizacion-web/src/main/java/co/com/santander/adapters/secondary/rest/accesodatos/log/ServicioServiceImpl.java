package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.clients.viabilizacion.ServicioClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.ServicioPayload;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.accesodatos.ServicioService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioClient servicioClient;

    @Autowired
    public ServicioServiceImpl(ServicioClient servicioClient) {
        this.servicioClient = servicioClient;
    }

    @Override
    public Optional<ServicioPayload> findServiceByService(GeneralPayload<ServicioEnum> servicio) {
        ResponseDto rtaService = servicioClient.findServiceByService(servicio).getBody();
        ServicioPayload servicioPayload = new Gson().fromJson(rtaService.getRespuestaServicio(), ServicioPayload.class);
        return Optional.of(servicioPayload);
    }
}
