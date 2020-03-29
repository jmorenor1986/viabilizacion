package co.com.santander.persistencia.service;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;

import java.util.Optional;

public interface ServicioService {

    Optional< ServicioEntity > findServiceByService(ServicioEnum servicio);

}
