package co.com.santander.core.services.log;

import co.com.santander.adapters.secondary.database.santander.entity.CacheUsrEntity;
import co.com.santander.adapters.secondary.database.santander.entity.LogEntity;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

}
