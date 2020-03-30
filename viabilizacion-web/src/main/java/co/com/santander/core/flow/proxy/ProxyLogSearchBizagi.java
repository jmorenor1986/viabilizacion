package co.com.santander.core.flow.proxy;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;
import co.com.santander.core.common.FlowOperationEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
<<<<<<< HEAD
import co.com.santander.ports.secondary.accesodatos.LogService;
=======
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.controller.payload.LogPayload;
>>>>>>> 89b0d4c225b317173cc1a53acfd87159f4a9dcbe
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("proxyLogSearchBizagi")
public class ProxyLogSearchBizagi implements ValidateRequest {

	private final ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private Long idRequest;
	
	@Autowired
	public ProxyLogSearchBizagi(@Qualifier("searchBizagi") ValidateRequest validateRequest, LogService logService) {
		this.validateRequest = validateRequest;
		this.logService = logService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setIdRequest(idRequest);
		generarLog(cliente);
		return validateRequest.process(cliente, idRequest);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogPayload.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getIdRequest())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.CASO_BIZAGI)
    			.build());
	}
	
}