package com.samtel.ports.primary.log;

import com.samtel.domain.log.LogGeneral;

public interface LogService {
	
	public void insertLogOperation(LogGeneral log);

}
