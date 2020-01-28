package com.samtel.core;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.domain.solicitud.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchCache")
public class SearchCacheImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(SearchCacheImpl.class);

    private ValidateRequest validateRequest;
    @Getter @Setter
    private Cliente cliente;

    @Autowired
    public SearchCacheImpl(@Qualifier("searchReconocer") ValidateRequest validateRequest) {
        this.validateRequest = validateRequest;
    }

    @Override
    public Optional<Boolean> process(Cliente cliente) {
        setCliente(cliente);
        validateRequest.process(getCliente());
        return Optional.of(Boolean.TRUE);
    }
}
