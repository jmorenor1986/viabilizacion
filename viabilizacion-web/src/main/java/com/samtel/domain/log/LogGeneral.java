package com.samtel.domain.log;

import java.util.Date;

import com.samtel.domain.repository.entity.FlowOperationEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class LogGeneral {

	private Long id;
	
	private String usuarioMicro;
	
	private FlowOperationEnum tipo;
	
	private String traza;
	
	private String idRequest;
	
	private Date fecha;
	
}