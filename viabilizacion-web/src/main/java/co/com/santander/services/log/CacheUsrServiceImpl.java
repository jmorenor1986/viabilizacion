package co.com.santander.services.log;

import co.com.santander.core.repository.ICacheUsrRepository;
import co.com.santander.domain.repository.entity.CacheUsrEntity;
import co.com.santander.domain.repository.entity.EstadoEnum;
import co.com.santander.domain.repository.entity.FlowOperationEnum;
import co.com.santander.domain.repository.entity.LogEntity;
import co.com.santander.ports.primary.log.CacheUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String evaluoTipo(FlowOperationEnum operation){
        if(operation.toString().contains("REQUEST")){
            return "REQUEST";
        }else if(operation.toString().contains("RESPONSE")){
            return "RESPONSE";
        }else{
            return "NA";
        }
    }
}
