package com.samtel.domain.log;

import com.samtel.domain.repository.entity.FlowOperationEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class LogGeneral {
	
	private Long id;
	private FlowOperationEnum flowOperation;
	private Long idRequest;
	private String parameters;

}
