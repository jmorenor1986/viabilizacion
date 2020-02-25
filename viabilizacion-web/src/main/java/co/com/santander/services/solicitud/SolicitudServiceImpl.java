package co.com.santander.services.solicitud;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.domain.log.LogGeneral;
import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.domain.solicitud.ClienteValidator;
import co.com.santander.ports.primary.log.LogService;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import co.com.santander.utils.IGenerateUniqueId;
import com.google.gson.Gson;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.domain.repository.entity.FlowOperationEnum;
import co.com.santander.errors.MandatoryFieldException;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	private final ClienteValidator clienteValidator;
	private final LogService logService;
	private final ValidateRequest validateRequest;
	private final IGenerateUniqueId generateUniqueId;

	private Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);
	
	@Getter @Setter
	private String requestId;

	@Autowired
	public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService,
			@Qualifier("proxyLogValidateCity") ValidateRequest validateRequest,IGenerateUniqueId generateUniqueId ) {
		this.clienteValidator = clienteValidator;
		this.logService = logService;
		this.validateRequest = validateRequest;
		this.generateUniqueId = generateUniqueId;
	}

	@Override
	public Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente) {
		log.info("Inicia solicitud de validación");
		if (clienteValidator.validateObject(cliente)) {
			setRequestId(generateUniqueId.generateUniqueIdStr(Long.valueOf(12)));
			generarLog(cliente);
			return validateRequest.process( cliente, getRequestId() );
		}
		throw new MandatoryFieldException("Request invalido", 400);
	}
	
	
	public void generarLog(Cliente cliente	) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogGeneral.builder().usuarioMicro("jsierra").idRequest(getRequestId())
				.traza(gsonCliente).tipo(FlowOperationEnum.VALIDATE_CLIENT).build());
	}
}