package com.samtel.core.flow.impl;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);

    @Setter
    private Cliente cliente;


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		setCliente(cliente);
		return Optional.of(ResponseFlow.FAST_TRACK);
	}

}
