package co.com.santander.core.services.log;

import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import co.com.santander.adapters.secondary.database.santander.entity.ServicioEntity;

import java.util.Optional;

public interface ServicioService {

    Optional< ServicioEntity > findServiceByService(ServicioEnum servicio);

}
