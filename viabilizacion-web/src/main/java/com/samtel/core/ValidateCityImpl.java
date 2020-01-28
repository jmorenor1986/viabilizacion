package com.samtel.core;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.domain.solicitud.RequestData;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("validateCity")
public class ValidateCityImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(ValidateCityImpl.class);
    private ValidateRequest validateRequest;
    @Getter @Setter
    private RequestData data;

    public ValidateCityImpl(@Qualifier("searchCache")ValidateRequest validateRequest) {
        this.validateRequest = validateRequest;
    }

    @Override
    public Optional<Boolean> process(RequestData data) {
        setData(data);
        log.info("Paso por validar ciudad");
        validateRequest.process(getData());
        return Optional.of(Boolean.TRUE);
    }
}