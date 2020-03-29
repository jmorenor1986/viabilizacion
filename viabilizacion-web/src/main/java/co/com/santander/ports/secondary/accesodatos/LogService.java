package co.com.santander.ports.secondary.accesodatos;

public interface LogService {

    public Boolean insertLogOperation(LogPayload log);

    public Boolean insertaLogRest(LogPayload log, String idCache);
}
