package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.ServicioService;
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
