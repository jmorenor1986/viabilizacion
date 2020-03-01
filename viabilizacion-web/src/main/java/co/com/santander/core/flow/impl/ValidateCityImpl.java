package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("validateCity")
public class ValidateCityImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(ValidateCityImpl.class);
    
    private ValidateRequest validateRequest;
    
    private ValidarCiudadService validarCiudadService;
    
    @Getter @Setter
    private Cliente cliente;
    
    @Autowired
    public ValidateCityImpl(@Qualifier("proxyLogSearchVigia")ValidateRequest validateRequest, ValidarCiudadService validarCiudadService) {
        this.validateRequest = validateRequest;
        this.validarCiudadService = validarCiudadService;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, String requestId) {
        setCliente(cliente);
        String validaCiudad = validarCiudadService.validarCodigoCiudad(getCliente().getCiudad(), requestId);
        log.info("Respuesta al validar ciudad {} ", validaCiudad );
        if("true".equalsIgnoreCase(validaCiudad)) {
        	return validateRequest.process(getCliente(), requestId);
        }else {
        	return Optional.of(ResponseFlow.INVALID_CITY) ;
        }
    }
    
}