package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.dto.viabilizacion.ServicioPayload;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.accesodatos.ServicioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {
    @Override
    public Optional<ServicioPayload> findServiceByService(ServicioEnum servicio) {
        return Optional.empty();
    }
}
