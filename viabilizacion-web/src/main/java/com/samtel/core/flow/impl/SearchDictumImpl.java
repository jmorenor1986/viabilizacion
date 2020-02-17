package com.samtel.core.flow.impl;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;
import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.ports.secondary.solicitud.DictumService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchDictum")
public class SearchDictumImpl implements ValidateRequest {

    private static final Logger log = LoggerFactory.getLogger(SearchDictumImpl.class);

    private ValidateRequest validateRequest;
    @Getter
    @Setter
    private Cliente cliente;

    private DictumService dictumService;
    private DictumClienteMapper dictumClienteMapper;

    @Autowired
    public SearchDictumImpl(@Qualifier("proxyLogSearchReconocer") ValidateRequest validateRequest, DictumService dictumService, DictumClienteMapper dictumClienteMapper) {
        super();
        this.validateRequest = validateRequest;
        this.dictumService = dictumService;
        this.dictumClienteMapper = dictumClienteMapper;
    }


    @Override
    public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
        setCliente(cliente);
        llamarSevicio();
        return validateRequest.process(getCliente(), idRequest);
    }

    public void llamarSevicio() {
        Optional<String> respuesta = dictumService.consultarSolicitudDictum(dictumClienteMapper.toRequestDictum(getCliente()));
        if (respuesta.isPresent())
            log.info("Esta es la respuesta del servicio: {}", respuesta.get());
    }

}