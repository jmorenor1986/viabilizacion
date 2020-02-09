package com.samtel.services.solicitud;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.errors.MandatoryFieldException;
import com.samtel.ports.primary.log.LogService;
import com.samtel.ports.primary.solicitud.SolicitudService;
import com.samtel.utils.IGenerateUniqueId;

import lombok.Getter;
import lombok.Setter;

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