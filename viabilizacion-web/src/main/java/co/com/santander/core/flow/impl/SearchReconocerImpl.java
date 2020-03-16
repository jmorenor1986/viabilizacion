package co.com.santander.core.flow.impl;

import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.utils.ValidatorInformacionContacto;
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
    private ValidateRequest validateRequestUbi;
    private ValidateRequest validateRequestBiz;
    @Getter
    @Setter
    private Cliente cliente;
    @Getter @Setter
    private Long requestId;
    private InformacionContactoService informacionContactoService;
    @Getter @Setter
    private ResponseInformacionContacto responseInformacionContacto;


    @Autowired
    public SearchReconocerImpl(@Qualifier("proxyLogSearchUbica") ValidateRequest validateRequestUbi, @Qualifier("proxyLogSearchBizagi")ValidateRequest validateRequestBiz, InformacionContactoService informacionContactoService) {
        super();
        this.validateRequestUbi = validateRequestUbi;
        this.validateRequestBiz = validateRequestBiz;
        this.informacionContactoService = informacionContactoService;
    }

    @Override
    public Optional<ResponseFlow> process(Cliente cliente, Long requestId) {
        setCliente(cliente);
        setRequestId(requestId);
        Boolean respuesta = callService();
        if( Boolean.FALSE.equals(respuesta)) {
            return validateRequestUbi.process(getCliente(), getRequestId());
        }
        return validateRequestBiz.process(getCliente(), getRequestId());
    }

    public Boolean callService() {
        Optional<ResponseInformacionContacto> respueta = informacionContactoService.consultarDatosUsuario(getCliente(), InformacionContacto.builder().build(), getRequestId());
        //En el caso de que no responda debe llamar a UBICA
        if(respueta.isPresent()){
            setResponseInformacionContacto(respueta.get());
            getCliente().setValidaReconocer(ValidatorInformacionContacto.builder().build().evaluaDatosContacto(getResponseInformacionContacto(),cliente));
            return getCliente().getValidaReconocer();
        }
        return Boolean.FALSE;
    }

}
