package co.com.santander.dto.viabilizacion;


import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
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