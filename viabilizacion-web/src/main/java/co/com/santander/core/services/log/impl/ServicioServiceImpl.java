package co.com.santander.core.services.log.impl;

import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import co.com.santander.adapters.secondary.database.santander.entity.ServicioEntity;
import co.com.santander.core.services.log.ServicioService;
import co.com.santander.ports.secondary.database.santander.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    private IServicioRepository servicioRepository;

    @Autowired
    public ServicioServiceImpl(IServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Optional<ServicioEntity> findServiceByService(ServicioEnum servicio) {
        return servicioRepository.findByServicio(servicio);
    }
}
