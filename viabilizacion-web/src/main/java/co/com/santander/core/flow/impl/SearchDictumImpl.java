package co.com.santander.core.flow.impl;

import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.DictumService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchDictum")
public class SearchDictumImpl implements ValidateRequest {

    private static final Logger log = LoggerFactory.getLogger(SearchDictumImpl.class);

    private ValidateRequest validateRequest;
    @Getter
    @Setter
    private Cliente cliente;
    @Getter
    @Setter
    private Long idRequest;
    @Getter
    @Setter
    private String respuestaDictum;

    private DictumService dictumService;

    @Autowired
    public SearchDictumImpl(@Qualifier("proxyLogSearchReconocer") ValidateRequest validateRequest, DictumService dictumService) {
        super();
        this.validateRequest = validateRequest;
        this.dictumService = dictumService;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
        setCliente(cliente);
        setIdRequest(idRequest);
        if (callService()) {
            getCliente().setDecision(respuestaDictum);
            return validateRequest.process(getCliente(), idRequest);
        }
        return Optional.of(ResponseFlow.DENIED);
    }

    public Boolean callService() {
        Optional<String> respuesta = dictumService.consultarSolicitudDictum(getCliente(), new Dictum(), getIdRequest());
        if (respuesta.isPresent()) {
            setRespuestaDictum(respuesta.get());
            if (DecisionDictum.SIN_RESPUESTA.equalsIgnoreCase(respuesta.get())
                    || DecisionDictum.ERROR_EN_PROCESO.equalsIgnoreCase(respuesta.get())
                    || DecisionDictum.NEGADO.equalsIgnoreCase(respuesta.get())
            )
                return Boolean.FALSE;
            //Si llega aquí quiere que dictum dio viabilidad para el credito
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}