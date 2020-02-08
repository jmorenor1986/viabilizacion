package com.samtel.services.solicitud;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.stream.Stream;

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

import lombok.Getter;
import lombok.Setter;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	private final ClienteValidator clienteValidator;
	private final LogService logService;
	private final ValidateRequest validateRequest;

	private Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);
	private static final SecureRandom rng = new SecureRandom();
	@Getter @Setter
	private String requestId;

	@Autowired
	public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService,
			@Qualifier("proxyLogValidateCity") ValidateRequest validateRequest) {
		this.clienteValidator = clienteValidator;
		this.logService = logService;
		this.validateRequest = validateRequest;
	}

	@Override
	public Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente) {
		log.info("Inicia solicitud de validación");
		if (clienteValidator.validateObject(cliente)) {
			setRequestId(generateRandomString(Long.valueOf(12)));
			generarLog(cliente);
			return validateRequest.process( cliente, getRequestId() );
		}
		throw new MandatoryFieldException("Request invalido", 400);
	}

	public String generateRandomString(long length) {
		rng.setSeed(System.currentTimeMillis());
		Stream<Character> randomCharStream = rng.ints(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
				.mapToObj(i -> (char) i).filter(c -> {
					return c >= '0' && c <= 'z' && Character.isLetterOrDigit(c);
				}).limit(length);

		return randomCharStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}

	public void generarLog(Cliente cliente	) {
		String gsonCliente = new Gson().toJson(cliente);
		logService.insertLogOperation(LogGeneral.builder().usuarioMicro("jsierra").idRequest(getRequestId())
				.traza(gsonCliente).tipo(FlowOperationEnum.VALIDATE_CLIENT).build());
	}
	
}