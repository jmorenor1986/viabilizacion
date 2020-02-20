package com.samtel.core.flow.impl;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	//private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);

    @Setter
    private Cliente cliente;


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, String idRequest) {
		setCliente(cliente);
		if(Boolean.TRUE.equals(cliente.getVigia())) {
			return Optional.of(ResponseFlow.PREAPROBADO_CON_DOCUMENTOS);
		}
		return Optional.of(ResponseFlow.FAST_TRACK);
	}

}
