package com.samtel.core.flow.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

import lombok.Getter;
import lombok.Setter;

@Component("validateCity")
public class ValidateCityImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(ValidateCityImpl.class);
    
    private ValidateRequest validateRequest;
    
    @Getter @Setter
    private Cliente cliente;
    
    @Autowired
    public ValidateCityImpl(@Qualifier("proxyLogSearchVigia")ValidateRequest validateRequest) {
        this.validateRequest = validateRequest;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, String requestId) {
        setCliente(cliente);
        return validateRequest.process(getCliente(), requestId);
    }
    
}