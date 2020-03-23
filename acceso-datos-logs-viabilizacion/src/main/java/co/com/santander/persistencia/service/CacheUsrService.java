package co.com.santander.persistencia.service;

import java.util.Optional;

import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

    Optional< String > validityLogUser(String cache, Long vig);

}
