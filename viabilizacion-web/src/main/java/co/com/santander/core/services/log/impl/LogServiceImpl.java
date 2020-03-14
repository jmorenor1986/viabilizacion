package co.com.santander.core.services.log.impl;

import co.com.santander.adapters.secondary.database.santander.entity.PrincipalRequest;
import co.com.santander.ports.secondary.database.santander.IServicioRepository;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.ports.primary.log.CacheUsrService;
import co.com.santander.ports.primary.log.LogService;
import com.google.gson.Gson;
import co.com.santander.ports.secondary.database.santander.ILogOperationRepository;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.adapters.secondary.database.santander.entity.LogEntity;
import co.com.santander.adapters.secondary.database.santander.entity.ServicioEntity;
import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    ILogOperationRepository logOperationRepository;

    IServicioRepository servicioRepository;

    ModelMapper modelMapper;

    CacheUsrService cacheUsrService;

    @Autowired
    public LogServiceImpl(ILogOperationRepository logOperationRepository, ModelMapper modelMapper, IServicioRepository servicioRepository, CacheUsrService cacheUsrService) {
        this.logOperationRepository = logOperationRepository;
        this.servicioRepository = servicioRepository;
        this.modelMapper = modelMapper;
        this.cacheUsrService = cacheUsrService;
    }

    @Override
    public Boolean insertLogOperation(LogGeneral log) {
        LogEntity logEntity = modelMapper.map(log, LogEntity.class);

        logEntity.setPrincipalRequest(PrincipalRequest.builder()
                .id(log.getIdRequest())
                .build());

        logOperationRepository.save(logEntity);
        return Boolean.TRUE;
    }

    @Override
    public Boolean insertaLogRest(LogGeneral log, String idCache) {
        Optional<LogEntity> logEntity = generaLogEntity(log);
        if (logEntity.isPresent()) {
            logEntity = Optional.of(logOperationRepository.save(logEntity.get()));
            if (logEntity.isPresent() &&
                    (
                            FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(logEntity.get().getTipo()) ||
                                    FlowOperationEnum.INVOKE_VIGIA_RESPONSE.equals(logEntity.get().getTipo()) ||
                                    FlowOperationEnum.INVOKE_DICTUM_RESPONSE.equals(logEntity.get().getTipo()) ||
                                    FlowOperationEnum.INVOKE_DICTUM_REQUEST.equals(logEntity.get().getTipo()) ||
                                    FlowOperationEnum.INVOKE_RECONOCER_REQUEST.equals(logEntity.get().getTipo()) ||
                                    FlowOperationEnum.INVOKE_RECONOCER_RESPONSE.equals(logEntity.get().getTipo())
                    )
            ) {
                cacheUsrService.insertLogCacheUsr(logEntity.get(), idCache);
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Optional<LogEntity> generaLogEntity(LogGeneral log) {
        LogEntity logEntity = modelMapper.map(log, LogEntity.class);
        //Generamos el principal request
        logEntity.setPrincipalRequest(PrincipalRequest.builder()
                .id(log.getIdRequest())
                .build());

        Optional<ServicioEntity> servicioEntity = servicioRepository.findByServicio(validaServicio(log.getTipo()));
        if (!servicioEntity.isPresent()) {
            this.logger.info("Error al guardrar log de servicio rest {}", new Gson().toJson(log));
            return Optional.empty();
        }
        logEntity.setServicio(servicioEntity.get());
        return Optional.of(logEntity);
    }

    private ServicioEnum validaServicio(FlowOperationEnum operationEnum) {
        if (FlowOperationEnum.VALIDATE_CITY.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_REQUEST.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.VALIDATE_CITY;
        } else if (FlowOperationEnum.INVOKE_VIGIA.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.VIGIA;
        } else if (FlowOperationEnum.INVOKE_DICTUM.equals(operationEnum) || FlowOperationEnum.INVOKE_DICTUM_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_DICTUM_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.DICTUM;
        } else if (FlowOperationEnum.INVOKE_RECONOCER.equals(operationEnum) || FlowOperationEnum.INVOKE_RECONOCER_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_RECONOCER_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.RECONOCER;
        } else if (FlowOperationEnum.CASO_BIZAGI.equals(operationEnum) || FlowOperationEnum.CASO_BIZAGI_REQUEST.equals(operationEnum) || FlowOperationEnum.CASO_BIZAGI_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.BIZAGI;
        }
        return ServicioEnum.NO_APLICA;
    }
}
