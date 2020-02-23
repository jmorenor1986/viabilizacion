package com.samtel.ports.primary.log;

import com.samtel.domain.log.LogGeneral;

public interface LogService {
	
	public Boolean insertLogOperation(LogGeneral log);

	public Boolean insertaLogRest(LogGeneral log, String idCache);

}
