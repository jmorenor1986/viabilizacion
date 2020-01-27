package com.samtel.domain.solicitud;

import com.samtel.utils.GenericValidator;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator extends GenericValidator<Cliente> {

    @Override
    protected boolean validateObject(Cliente dto) {
        return false;
    }
}
