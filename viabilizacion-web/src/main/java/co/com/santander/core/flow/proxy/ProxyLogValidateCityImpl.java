package co.com.santander.core.flow.proxy;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.controller.payload.LogPayload;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("proxyLogValidateCity")
public class ProxyLogValidateCityImpl implements ValidateRequest {

	private ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private Long requestId;
	
	@Autowired
	public ProxyLogValidateCityImpl(@Qualifier("validateCity") ValidateRequest validateRequest,LogService logService) {
		this.validateRequest = validateRequest;
		this.logService = logService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
		setRequestId(requestId);
		generarLog(cliente);
		return validateRequest.process(cliente,requestId);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogPayload.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getRequestId())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.VALIDATE_CITY)
    			.build());
	}

}
