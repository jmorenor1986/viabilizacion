package com.samtel.services.solicitud;

import com.google.gson.Gson;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.errors.MandatoryFieldException;
import com.samtel.ports.primary.log.LogService;
import com.samtel.ports.primary.solicitud.SolicitudService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    private final ClienteValidator clienteValidator;
    private final LogService logService;
    
    private Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);

    @Autowired
    public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService) {
        this.clienteValidator = clienteValidator;
        this.logService = logService;
    }

    @Override
    public Optional<String> cumplimientoSolicitud(Cliente cliente) {
        if (clienteValidator.validateObject(cliente)) {
        	String gsonCliente = new Gson().toJson(cliente); 
        	log.info("Este es el json: " + gsonCliente);
        	logService.insertLogOperation(LogGeneral.builder()
        			.usuarioMicro("jsierra")
        			.idRequest(Long.valueOf("1"))
        			.traza(gsonCliente)
        			.tipo(FlowOperationEnum.VALIDATE_CLIENT)
        			.build());
        	return Optional.of("Validation Ok");
        }            
        throw new MandatoryFieldException("Request invalido", 400);
    }
    
}