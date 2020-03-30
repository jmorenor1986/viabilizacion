package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;
import co.com.santander.ports.secondary.accesodatos.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Override
    public Boolean insertLogOperation(LogPayload log) {
        return null;
    }

    @Override
    public Boolean insertaLogRest(LogPayload log, String idCache) {
        return null;
    }
}
