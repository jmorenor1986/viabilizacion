package co.com.santander.core.flow.impl;

import co.com.santander.adapters.secondary.rest.bizagi.BizagiServiceImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.EnvioCorreoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchBizagi")
public class SearchBizagiImpl implements ValidateRequest {
	
	//private static final Logger log= LoggerFactory.getLogger(SearchBizagiImpl.class);
	private final BizagiServiceImpl bizagiService;
	private final EnvioCorreoService envioCorreoService;


    @Setter @Getter
    private Cliente cliente;
	@Setter @Getter
    private Long requestId;

	@Autowired
	public SearchBizagiImpl(BizagiServiceImpl bizagiService, EnvioCorreoService envioCorreoService) {
		this.bizagiService = bizagiService;
		this.envioCorreoService = envioCorreoService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setCliente(cliente);
		setRequestId(idRequest);
		getCliente().setDecisionFinal( ResponseFlow.evaluaRespuesta( getCliente().getDecision() ));
		envioCorreoService.envioCorreo(cliente, idRequest);
		return Optional.of( getCliente().getDecisionFinal() );
	}

	private void callService(){
		Optional<String> respuestaCase = bizagiService.createCaseBizagi(getCliente(),getRequestId());
	}

}
