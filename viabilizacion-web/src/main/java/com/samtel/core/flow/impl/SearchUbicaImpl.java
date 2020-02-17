package com.samtel.core.flow.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;

import lombok.Getter;
import lombok.Setter;

@Component("searchUbica")
public class SearchUbicaImpl implements ValidateRequest {

	//private static final Logger log = LoggerFactory.getLogger(SearchUbicaImpl.class);

	private ValidateRequest validateRequest;
	@Setter @Getter
	private Cliente cliente;
	
	@Autowired
	public SearchUbicaImpl(@Qualifier("proxyLogSearchBizagi")ValidateRequest validateRequest) {
		super();
		this.validateRequest = validateRequest;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		setCliente(cliente);
		return validateRequest.process(getCliente(), idRequest);
	}

}
