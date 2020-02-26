package co.com.santander.core.flow.proxy;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.domain.log.LogGeneral;
import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.ports.primary.log.LogService;
import com.google.gson.Gson;
import co.com.santander.domain.repository.entity.FlowOperationEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("proxyLogSearchCache")
public class ProxyLogSearchCache implements ValidateRequest {

	private final ValidateRequest validateRequest;
	private final LogService logService;
	@Getter @Setter
	private String idRequest;
	
	@Autowired
	public ProxyLogSearchCache(@Qualifier("searchCache") ValidateRequest validateRequest, LogService logService) {
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
    			.tipo(FlowOperationEnum.SEARCH_CACHE)
    			.build());
	}

}