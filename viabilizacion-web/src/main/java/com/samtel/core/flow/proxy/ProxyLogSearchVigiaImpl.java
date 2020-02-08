package com.samtel.core.flow.proxy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.primary.log.LogService;

import lombok.Getter;
import lombok.Setter;

@Component("proxyLogSearchVigia")
public class ProxyLogSearchVigiaImpl implements ValidateRequest {
	
	private ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private String requestId;
	
	
	@Autowired
	public ProxyLogSearchVigiaImpl(@Qualifier("searchVigia")ValidateRequest validateRequest, LogService logService) {
		super();
		this.validateRequest = validateRequest;
		this.logService = logService;
	}


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		setRequestId(idRequest);
		generarLog(cliente);
		return validateRequest.process(cliente, idRequest);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogGeneral.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getRequestId())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.INVOKE_VIGIA)
    			.build());
	}

}
