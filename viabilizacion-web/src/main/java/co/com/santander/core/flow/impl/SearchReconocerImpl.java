package co.com.santander.core.flow.impl;

import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
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

    private static final Logger log = LoggerFactory.getLogger(SearchReconocerImpl.class);
    private ValidateRequest validateRequest;
    @Getter
    @Setter
    private Cliente cliente;
    @Getter @Setter
    private Long requestId;
    private InformacionContactoService informacionContactoService;

    @Autowired
    public SearchReconocerImpl(@Qualifier("proxyLogSearchUbica") ValidateRequest validateRequest, InformacionContactoService informacionContactoService) {
        super();
        this.validateRequest = validateRequest;
        this.informacionContactoService = informacionContactoService;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
        setCliente(cliente);
        setRequestId(requestId);
        callService();
        return validateRequest.process(getCliente(), requestId);
    }

    public void callService() {
        ResponseInformacionContacto respueta = informacionContactoService.consultarDatosUsuario(getCliente(), InformacionContacto.builder().build(), getRequestId());
        log.info("Esta es la respuesta: {}",respueta);

    }
}
