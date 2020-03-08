package co.com.santander.core.flow.impl;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.validarciudad.dto.ValidarCiudad;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("validateCity")
public class ValidateCityImpl implements ValidateRequest {

    private static final Logger log = LoggerFactory.getLogger(ValidateCityImpl.class);

    private ValidateRequest validateRequest;

    private ValidarCiudadService validarCiudadService;

    private ModelMapper mapper;

    @Getter
    @Setter
    private Cliente cliente;
    @Getter
    @Setter
    private Long requestId;

    @Autowired
    public ValidateCityImpl(@Qualifier("proxyLogSearchVigia") ValidateRequest validateRequest, ValidarCiudadService validarCiudadService, ModelMapper mapper) {
        this.validateRequest = validateRequest;
        this.validarCiudadService = validarCiudadService;
        this.mapper = mapper;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
        setCliente(cliente);
        setRequestId(requestId);
        if ("true".equalsIgnoreCase(callService())) {
            return validateRequest.process(getCliente(), requestId);
        } else {
            return Optional.of(ResponseFlow.INVALID_CITY);
        }
    }

    public String callService(){
        return validarCiudadService.validarCodigoCiudad(GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(mapper.map(getCliente().getRequestHeader(), RequestHeader.class))
                .requestBody(ValidarCiudad.builder()
                        .ciudad(getCliente().getCiudad())
                        .build())
                .build()
                , getRequestId());
    }

}