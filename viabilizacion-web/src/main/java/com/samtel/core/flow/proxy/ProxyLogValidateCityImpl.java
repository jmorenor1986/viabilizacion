package com.samtel.core.flow.proxy;

import com.google.gson.Gson;
import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.primary.log.LogService;
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
	private String requestId;
	
	@Autowired
	public ProxyLogValidateCityImpl(@Qualifier("validateCity") ValidateRequest validateRequest,LogService logService) {
		this.validateRequest = validateRequest;
		this.logService = logService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente,String requestId) {
		setRequestId(requestId);
		generarLog(cliente);
		return validateRequest.process(cliente,requestId);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogGeneral.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getRequestId())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.VALIDATE_CITY)
    			.build());
	}

}
