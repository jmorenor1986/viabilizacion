package com.samtel.domain.log;

import com.samtel.domain.repository.entity.FlowOperationEnum;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LogGeneral {

	private Long id;
	
	private String usuarioMicro;
	
	private FlowOperationEnum tipo;
	
	private String traza;
	
	private String idRequest;
	
	private Date fecha;

	private HttpStatus httpStatus;

	private String url;
	
}