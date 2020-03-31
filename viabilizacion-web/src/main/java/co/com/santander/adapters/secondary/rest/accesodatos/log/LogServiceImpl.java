package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.clients.viabilizacion.LogClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.ports.secondary.accesodatos.LogService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogClient logClient;

    @Autowired
    public LogServiceImpl(LogClient logClient) {
        this.logClient = logClient;
    }

    @Override
    public Boolean insertLogOperation(GeneralPayload<LogPayload> log) {
        ResponseDto rta = logClient.insertLogOperation(log).getBody();
        return Boolean.TRUE;
    }

    @Override
    public Boolean insertaLogRest(GeneralPayload<LogPayload> log, String idCache) {
        return null;
    }
}
