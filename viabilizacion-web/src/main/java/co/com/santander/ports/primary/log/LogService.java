package co.com.santander.ports.primary.log;

import co.com.santander.domain.log.LogGeneral;

public interface LogService {
	
	public Boolean insertLogOperation(LogGeneral log);

	public Boolean insertaLogRest(LogGeneral log, String idCache);

}
