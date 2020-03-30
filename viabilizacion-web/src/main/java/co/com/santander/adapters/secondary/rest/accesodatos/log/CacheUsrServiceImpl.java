package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.CachePayload;
import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;
import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CacheUsrServiceImpl implements CacheUsrService {

    @Override
    public CachePayload insertLogCacheUsr(LogPayload log, String cache) {
        return null;
    }

    @Override
    public Optional<String> validityLogUser(String cache, Long vig) {
        return Optional.empty();
    }
}