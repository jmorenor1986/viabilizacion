package co.com.santander.persistencia.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.santander.persistencia.common.constants.EstadoEnum;
import co.com.santander.persistencia.common.constants.FlowOperationEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.repository.ICacheUsrRepository;
import co.com.santander.persistencia.service.CacheUsrService;

@Service
public class CacheUsrServiceImpl implements CacheUsrService {

    private ICacheUsrRepository cacheUsrRepository;

    @Autowired
    public CacheUsrServiceImpl(ICacheUsrRepository cacheUsrRepository) {
        this.cacheUsrRepository = cacheUsrRepository;
    }

    @Override
    public CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache) {
        cacheUsrRepository.inactiveCacheUsr(cache, evaluoTipo(log.getTipo()));
        return cacheUsrRepository.save(CacheUsrEntity.builder()
                .logs(log)
                .estado(EstadoEnum.ACTIVO)
                .paramBusq(cache)
                .tipo(evaluoTipo(log.getTipo()))
                .build());
    }

    @Override
    public Optional<String> validityLogUser(String cache, Long vig) {
        Optional< CacheUsrEntity > cacheEntity = cacheUsrRepository.findByParamBusqAndEstadoAndTipo(cache, EstadoEnum.ACTIVO, "RESPONSE");
        if(cacheEntity.isPresent()){
            return isValidLogDate(cacheEntity.get().getLogs().getFecha(), vig) ?  Optional.of(cacheEntity.get().getLogs().getTraza()) : Optional.empty();
        }
        return Optional.empty();
    }

    private Boolean isValidLogDate(Date logDate, Long vig){
        Long diffTime = new Date().getTime() - logDate.getTime();
        Long diffDays = diffTime / (1000 * 60 * 60 * 24);
        if(diffDays < vig){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public String evaluoTipo(FlowOperationEnum operation) {
        if (operation.toString().contains("REQUEST")) {
            return "REQUEST";
        } else if (operation.toString().contains("RESPONSE")) {
            return "RESPONSE";
        } else {
            return "NA";
        }
    }
}
