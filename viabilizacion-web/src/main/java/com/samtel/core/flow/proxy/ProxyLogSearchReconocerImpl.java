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

@Component("proxyLogSearchReconocer")
public class ProxyLogSearchReconocerImpl implements ValidateRequest {

	private final ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private String idRequest;
	
	@Autowired
	public ProxyLogSearchReconocerImpl(@Qualifier("searchReconocer") ValidateRequest validateRequest, LogService logService) {
		this.validateRequest = validateRequest;
		this.logService = logService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		setIdRequest(idRequest);
		generarLog(cliente);
		return validateRequest.process(cliente, idRequest);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogGeneral.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getIdRequest())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.INVOKE_RECONOCER)
    			.build());
	}
}
