package co.com.santander.core.flow.impl;

import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;
import co.com.santander.ports.secondary.solicitud.VigiaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component("searchVigia")
public class SearchVigiaImpl implements ValidateRequest {

    //private static final Logger log = LoggerFactory.getLogger(SearchVigiaImpl.class);

    private ValidateRequest validateRequest;
    private VigiaService vigiaService;

    @Getter
    @Setter
    private Cliente cliente;
    @Getter
    @Setter
    private Long idRequest;
    @Getter
    @Setter
    private ListaCliente listaCliente;

    @Autowired
    public SearchVigiaImpl(@Qualifier("proxyLogSearchCache") ValidateRequest validateRequest,
                           VigiaService vigiaService) {
        this.validateRequest = validateRequest;
        this.vigiaService = vigiaService;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, Long idRequest) {
        setCliente(cliente);
        setIdRequest(idRequest);
        getCliente().setVigia(buscarVigia(getCliente()));
        return validateRequest.process(getCliente(), idRequest);
    }

    /**
     * En el caso de encontrar un dato afirmativo se marca el objeto
     *
     * @param cliente
     * @return
     */
    public Boolean buscarVigia(Cliente cliente) {
        // Consumo el servicio vigia
        setListaCliente(vigiaService.consultarListasCliente(cliente, getIdRequest()));
        if (Objects.isNull(getListaCliente()))
            return Boolean.FALSE;
        else if ("S".equalsIgnoreCase(getListaCliente().getEncontradoId())
                || "S".equalsIgnoreCase(getListaCliente().getEncontradoNombre())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
