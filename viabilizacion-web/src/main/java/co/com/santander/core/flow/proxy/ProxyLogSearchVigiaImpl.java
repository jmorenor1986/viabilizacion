package co.com.santander.core.flow.proxy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.persistencia.constants.FlowOperationEnum;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.service.dto.LogPayload;
import lombok.Getter;
import lombok.Setter;

@Component("proxyLogSearchVigia")
public class ProxyLogSearchVigiaImpl implements ValidateRequest {
	
	private ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private Long requestId;
	
	
	@Autowired
	public ProxyLogSearchVigiaImpl(@Qualifier("searchVigia")ValidateRequest validateRequest, LogService logService) {
		super();
		this.validateRequest = validateRequest;
		this.logService = logService;
	}


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setRequestId(idRequest);
		generarLog(cliente);
		return validateRequest.process(cliente, idRequest);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogPayload.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getRequestId())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.INVOKE_VIGIA)
    			.build());
	}

}
