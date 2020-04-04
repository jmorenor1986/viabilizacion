package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.common.EstadoEnum;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.repository.ICacheUsrRepository;
import co.com.santander.persistencia.service.CacheUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        cacheUsrRepository.inactiveCacheUsr(cache, evaluoTipo(log.getTipo()), log.getTipo());
        return cacheUsrRepository.save(CacheUsrEntity.builder()
                .logs(log)
                .estado(EstadoEnum.ACTIVO)
                .paramBusq(cache)
                .tipo(evaluoTipo(log.getTipo()))
                .tipoLog(log.getTipo())
                .build());
    }

    @Override
    public Optional<String> validityLogUser(String cache, Long vig, FlowOperationEnum operation) {
        Optional< CacheUsrEntity > cacheEntity = cacheUsrRepository.findLogInCache(cache, EstadoEnum.ACTIVO, "RESPONSE", operation);
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
