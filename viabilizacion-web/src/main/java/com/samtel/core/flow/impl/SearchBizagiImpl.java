package com.samtel.core.flow.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

import lombok.Getter;
import lombok.Setter;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);

    @Getter @Setter
    private Cliente cliente;


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		//Genero la respuesta
		return Optional.of(ResponseFlow.FAST_TRACK);
	}

}
