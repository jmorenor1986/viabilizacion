package co.com.santander.adapters.secondary.rest.dictum.mapper.impl;

import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.RequestBody;
import co.com.santander.core.domain.solicitud.dictum.RequestDictum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DictumClienteMapperImpl implements DictumClienteMapper {

    private RequestHeader requestHeader;

    //@Autowired
    //public DictumClienteMapperImpl(RequestHeader requestHeader) {
    //    this.requestHeader = requestHeader;
    //}

    @Override
    public RequestDictum toRequestDictum(Cliente cliente) {
        return RequestDictum.builder()
                .requestBody(toRequestBodyFromClient(cliente))
                .requestHeader(requestHeader)
                .build();
    }

    public RequestBody toRequestBodyFromClient(Cliente cliente) {
        /* TODO Se debe validar la obtencion de estos parametos*/
        return RequestBody.builder()
                .clave("123")
                .primerApellido(cliente.getApellidos())
                .producto("DICTUM")
                .build();
    }
}