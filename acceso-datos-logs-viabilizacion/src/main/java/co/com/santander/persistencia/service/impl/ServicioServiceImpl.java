package co.com.santander.persistencia.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.santander.persistencia.common.constants.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.ServicioService;

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
