package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.domain.solicitud.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
