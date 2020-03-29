package co.com.santander.persistencia.service;

import co.com.santander.persistencia.controller.logservice.payload.LogPayload;

public interface LogService {

	public Boolean insertLogOperation(LogPayload log);

	public Boolean insertaLogRest(LogPayload log, String idCache);

}
