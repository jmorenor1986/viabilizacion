package com.samtel.services.log;

import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.LogEntity;
import com.samtel.ports.primary.log.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
	
	ILogOperationRepository logOperationRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public LogServiceImpl(ILogOperationRepository logOperationRepository, ModelMapper modelMapper) {
		this.logOperationRepository = logOperationRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Boolean insertLogOperation(LogGeneral log) {
		logOperationRepository.save(modelMapper.map(log, LogEntity.class));	
		return Boolean.TRUE;
	}

}
