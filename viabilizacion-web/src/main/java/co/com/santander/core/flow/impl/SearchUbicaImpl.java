package co.com.santander.core.flow.impl;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.UbicaService;
import co.com.santander.utils.ValidatorInformacionContacto;
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
	@Getter @Setter
	private Long idRequest;
	private UbicaService ubicaService;
	
	@Autowired
	public SearchUbicaImpl(@Qualifier("proxyLogSearchBizagi")ValidateRequest validateRequest
			, @Qualifier("proxyUbicaServiceImpl") UbicaService ubicaService ) {
		super();
		this.validateRequest = validateRequest;
		this.ubicaService = ubicaService;
	}

	@Override
	public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
		setCliente(cliente);
		setIdRequest(idRequest);
		callService();
		return validateRequest.process(getCliente(), idRequest);
	}

	public void callService(){
		Optional<ResponseInformacionContacto> respuesta = ubicaService.consultarInformacionContacto(getCliente(), InformacionContacto.builder().build(), getIdRequest());
		if(respuesta.isPresent()){
			getCliente().setValidaUbica(ValidatorInformacionContacto.builder().build().evaluaDatosContacto(respuesta.get(),cliente));
		}
		getCliente().setValidaUbica(Boolean.FALSE);
	}

}
