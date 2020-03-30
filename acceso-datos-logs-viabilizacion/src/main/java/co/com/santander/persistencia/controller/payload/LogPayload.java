package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.common.FlowOperationEnum;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

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