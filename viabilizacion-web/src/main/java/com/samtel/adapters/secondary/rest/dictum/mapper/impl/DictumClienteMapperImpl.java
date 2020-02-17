package com.samtel.adapters.secondary.rest.dictum.mapper.impl;

import com.samtel.domain.solicitud.dictum.RequestBody;
import com.samtel.domain.solicitud.dictum.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.dictum.RequestDictum;

@Component
public class DictumClienteMapperImpl implements DictumClienteMapper {

    private RequestHeader requestHeader;

    @Autowired
    public DictumClienteMapperImpl(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    @Override
    public RequestDictum toRequestDictum(Cliente cliente) {
        return RequestDictum.builder()
                .requestBody(RequestBody.builder().build())
                .requestHeader(requestHeader)
                .build();
    }
}
