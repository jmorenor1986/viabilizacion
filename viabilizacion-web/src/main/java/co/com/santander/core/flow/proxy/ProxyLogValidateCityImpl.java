package co.com.santander.core.flow.proxy;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.primary.FindUrlService;
import co.com.santander.ports.secondary.accesodatos.LogService;
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
	private final FindUrlService findUrlService;
	@Getter @Setter
	private Long requestId;
	
	@Autowired
	public ProxyLogValidateCityImpl(@Qualifier("validateCity") ValidateRequest validateRequest,LogService logService, FindUrlService findUrlService) {
		this.validateRequest = validateRequest;
		this.logService = logService;
		this.findUrlService = findUrlService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
		setRequestId(requestId);
		generarLog(cliente);
		return validateRequest.process(cliente,requestId);
	}
	
	public void generarLog(Cliente cliente ) {
		String gsonCliente = new Gson().toJson(cliente);
		GeneralPayload<LogPayload> request = GeneralPayload.<LogPayload>builder()
				.requestHeader(cliente.getRequestHeader())
				.requestBody(LogPayload.builder()
						.usuarioMicro("jsierra")
						.idRequest(getRequestId())
						.traza(gsonCliente)
						.tipo(FlowOperationEnum.VALIDATE_CITY)
						.url(findUrlService.getUrlFrom(ServicioEnum.VALIDATE_CITY).get())
						.build())
				.build();
		logService.insertLogOperation(request);
	}

}
