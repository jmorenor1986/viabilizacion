package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	//private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);

    @Setter
    private Cliente cliente;
	@Setter
    private Long requestId;


	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setCliente(cliente);
		setRequestId(requestId);
		if(Boolean.TRUE.equals(cliente.getVigia())) {
			return Optional.of(ResponseFlow.PREAPROBADO_CON_DOCUMENTOS);
		}
		return Optional.of(ResponseFlow.FAST_TRACK);
	}

}
