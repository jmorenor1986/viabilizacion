package com.samtel.services.log;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.LogOperationEntity;
import com.samtel.ports.primary.log.LogService;

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
	public void insertLogOperation(LogGeneral log) {
		logOperationRepository.save(modelMapper.map(log, LogOperationEntity.class));	
	}

}
