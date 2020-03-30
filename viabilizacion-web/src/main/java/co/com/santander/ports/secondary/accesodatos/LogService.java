package co.com.santander.ports.secondary.accesodatos;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;

public interface LogService {

    Boolean insertLogOperation(LogPayload log);

    Boolean insertaLogRest(LogPayload log, String idCache);
}
