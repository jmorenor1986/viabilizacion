package com.samtel.domain.solicitud;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClienteValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Cliente.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
