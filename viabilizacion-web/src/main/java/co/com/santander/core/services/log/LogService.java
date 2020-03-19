package co.com.santander.core.services.log;

import co.com.santander.core.domain.log.LogGeneral;

public interface LogService {
	
	public Boolean insertLogOperation(LogGeneral log);

	public Boolean insertaLogRest(LogGeneral log, String idCache);

}
