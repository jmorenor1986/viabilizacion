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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    private final ClienteValidator clienteValidator;
    private final LogService logService;

    @Autowired
    public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService) {
        this.clienteValidator = clienteValidator;
        this.logService = logService;
    }

    @Override
    public Optional<String> cumplimientoSolicitud(Cliente cliente) {
        if (clienteValidator.validateObject(cliente)) {
        	logService.insertLogOperation(LogGeneral.builder()
        			.idRequest(Long.valueOf("1"))
        			.parameters(new Gson().toJson(cliente))
        			.flowOperation(FlowOperationEnum.VALIDATE_CLIENT)
        			.build());
        	return Optional.of("Validation Ok");
        }            
        throw new MandatoryFieldException("Request invalido", 400);
    }
    
}