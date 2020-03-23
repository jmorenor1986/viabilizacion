package co.com.santander.core.flow.impl;

import co.com.santander.adapters.secondary.rest.bizagi.BizagiServiceImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	//private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);
	private final BizagiServiceImpl bizagiService;


    @Setter @Getter
    private Cliente cliente;
	@Setter @Getter
    private Long requestId;

	@Autowired
	public SearchBizagiImpl(BizagiServiceImpl bizagiService) {
		this.bizagiService = bizagiService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setCliente(cliente);
		setRequestId(idRequest);
		callService();
		if(Boolean.TRUE.equals(cliente.getVigia())) {
			return Optional.of(ResponseFlow.PREAPROBADO_CON_DOCUMENTOS);
		}
		return Optional.of(ResponseFlow.FAST_TRACK);
	}

	private void callService(){
		Optional<String> respuestaCase = bizagiService.createCaseBizagi(getCliente(),getRequestId());
	}

}
