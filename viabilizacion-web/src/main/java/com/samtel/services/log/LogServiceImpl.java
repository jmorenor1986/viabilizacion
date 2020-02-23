package com.samtel.services.log;

import com.google.gson.Gson;
import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.core.repository.IServicioRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.repository.entity.LogEntity;
import com.samtel.domain.repository.entity.ServicioEntity;
import com.samtel.domain.repository.entity.ServicioEnum;
import com.samtel.ports.primary.log.LogService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    private static final Logger logger= LoggerFactory.getLogger(LogServiceImpl.class);

    ILogOperationRepository logOperationRepository;
    IServicioRepository servicioRepository;
    ModelMapper modelMapper;

    @Autowired
    public LogServiceImpl(ILogOperationRepository logOperationRepository, ModelMapper modelMapper, IServicioRepository servicioRepository) {
        this.logOperationRepository = logOperationRepository;
        this.servicioRepository = servicioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean insertLogOperation(LogGeneral log) {
        logOperationRepository.save(modelMapper.map(log, LogEntity.class));
        return Boolean.TRUE;
    }

    @Override
    public Boolean insertaLogRest(LogGeneral log, String idCache) {
        Optional<LogEntity> logEntity = generaLogEntity(log);
        if(logEntity.isPresent()){
            logOperationRepository.save(logEntity.get());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Optional<LogEntity> generaLogEntity(LogGeneral log){
        LogEntity logEntity = modelMapper.map(log, LogEntity.class);
        Optional<ServicioEntity> servicioEntity = servicioRepository.findByServicio(validaServicio(log.getTipo()));
        if(!servicioEntity.isPresent()){
            this.logger.info("Error al guardrar log de servicio rest {}", new Gson().toJson(log));
            return Optional.empty();
        }
        logEntity.setServicio(servicioEntity.get());
        return Optional.of(logEntity);
    }

    public ServicioEnum validaServicio(FlowOperationEnum operationEnum) {
        if (FlowOperationEnum.VALIDATE_CITY.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_REQUEST.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_RESPONSE.equals(operationEnum)) {
			return ServicioEnum.VALIDATE_CITY;
        } else if(FlowOperationEnum.INVOKE_VIGIA.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_RESPONSE.equals(operationEnum)){
            return ServicioEnum.VIGIA;
        }
        return ServicioEnum.NO_APLICA;
    }

}
