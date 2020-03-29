package co.com.santander.ports.secondary.accesodatos;

import java.util.Optional;

public interface CacheUsrService {

    CachePayload insertLogCacheUsr(LogPayload log, String cache);

    Optional< String > validityLogUser(String cache, Long vig);

}
