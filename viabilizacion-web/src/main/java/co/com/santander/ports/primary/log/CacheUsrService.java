package co.com.santander.ports.primary.log;

import co.com.santander.adapters.secondary.database.santander.entity.CacheUsrEntity;
import co.com.santander.adapters.secondary.database.santander.entity.LogEntity;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

}
