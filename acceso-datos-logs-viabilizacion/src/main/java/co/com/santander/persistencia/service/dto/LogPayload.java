package co.com.santander.persistencia.service.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

import co.com.santander.persistencia.common.FlowOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LogPayload {

	private Long id;
	
	private String usuarioMicro;
	
	private FlowOperationEnum tipo;
	
	private String traza;
	
	private Long idRequest;
	
	private Date fecha;

	private HttpStatus httpStatus;

	private String url;
	
}