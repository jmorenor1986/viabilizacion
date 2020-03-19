package co.com.santander.core.flow.proxy;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.services.log.LogService;
import com.google.gson.Gson;
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
	private Long idRequest;
	
	@Autowired
	public ProxyLogSearchReconocerImpl(@Qualifier("searchReconocer") ValidateRequest validateRequest, LogService logService) {
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
		logService.insertLogOperation(LogGeneral.builder()
    			.usuarioMicro("jsierra")
    			.idRequest(getIdRequest())
    			.traza(gsonCliente)
    			.tipo(FlowOperationEnum.INVOKE_RECONOCER)
    			.build());
	}
}
