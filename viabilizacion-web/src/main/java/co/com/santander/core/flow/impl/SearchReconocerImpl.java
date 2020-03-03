package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchReconocer")
public class SearchReconocerImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(SearchReconocerImpl.class);
    private ValidateRequest validateRequest;
    @Getter @Setter
    private Cliente cliente;

    @Autowired
    public SearchReconocerImpl(@Qualifier("proxyLogSearchUbica")ValidateRequest validateRequest) {
		super();
		this.validateRequest = validateRequest;
	}

	@Override
    public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
        setCliente(cliente);
        return validateRequest.process(getCliente(), requestId);
    }
}
