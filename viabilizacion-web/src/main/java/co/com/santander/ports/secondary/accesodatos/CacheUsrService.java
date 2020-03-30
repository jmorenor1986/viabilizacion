package co.com.santander.ports.secondary.accesodatos;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.CachePayload;
import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;

import java.util.Optional;

public interface CacheUsrService {

    CachePayload insertLogCacheUsr(LogPayload log, String cache);

    Optional< String > validityLogUser(String cache, Long vig);

}
