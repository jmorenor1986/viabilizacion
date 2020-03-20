package co.com.santander.core.services.log.impl;

import co.com.santander.ports.secondary.database.santander.ICacheUsrRepository;
import co.com.santander.adapters.secondary.database.santander.entity.CacheUsrEntity;
import co.com.santander.adapters.secondary.database.santander.constants.EstadoEnum;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.adapters.secondary.database.santander.entity.LogEntity;
import co.com.santander.core.services.log.CacheUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<String> validityLogUser(String cache) {
        Optional< CacheUsrEntity > cacheEntity = cacheUsrRepository.findByParamBusqAndEstadoAndTipo(cache, EstadoEnum.ACTIVO, "RESPONSE");
        if(cacheEntity.isPresent()){
            return Optional.of(cacheEntity.get().getLogs().getTraza());
        }
        return Optional.empty();
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
