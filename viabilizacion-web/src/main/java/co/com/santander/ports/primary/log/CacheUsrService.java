package co.com.santander.ports.primary.log;

import co.com.santander.domain.repository.entity.CacheUsrEntity;
import co.com.santander.domain.repository.entity.LogEntity;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

}
