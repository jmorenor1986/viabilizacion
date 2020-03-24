package co.com.santander.persistencia.service;

import java.util.Optional;

import co.com.santander.persistencia.constants.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;

public interface ServicioService {

    Optional< ServicioEntity > findServiceByService(ServicioEnum servicio);

}
