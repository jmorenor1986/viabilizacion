package co.com.santander.ports.secondary.accesodatos;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.viabilizacion.LogPayload;

public interface LogService {

    Boolean insertLogOperation(GeneralPayload<LogPayload> log);

    Boolean insertaLogRest(LogPayload log, String idCache);
}
