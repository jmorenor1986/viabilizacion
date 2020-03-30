package co.com.santander.core.services.solicitud;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;
import co.com.santander.adapters.secondary.rest.accesodatos.payload.PrincipalRequestPayload;
import co.com.santander.core.common.FlowOperationEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ClienteValidator;
import co.com.santander.core.errors.MandatoryFieldException;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import co.com.santander.ports.secondary.accesodatos.LogService;
import co.com.santander.ports.secondary.accesodatos.PrincipalRequestService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final ClienteValidator clienteValidator;
    private final LogService logService;
    private final PrincipalRequestService principalRequestService;
    private final ValidateRequest validateRequest;


    @Getter
    @Setter
    private Long principalRequestId;

    @Autowired
    public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService,
                                @Qualifier("proxyLogValidateCity") ValidateRequest validateRequest, PrincipalRequestService principalRequestService) {
        this.clienteValidator = clienteValidator;
        this.logService = logService;
        this.validateRequest = validateRequest;
        this.principalRequestService = principalRequestService;
    }

    @Override
    public Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente) {
        if (clienteValidator.validateObject(cliente)) {
            generatePrincipalRequest(cliente);
            generarLog(cliente);
            return validateRequest.process(cliente, getPrincipalRequestId());
        }
        throw new MandatoryFieldException("Request invalido", 400);
    }


    public void generarLog(Cliente cliente) {
        String gsonCliente = new Gson().toJson(cliente);
        logService.insertLogOperation(LogPayload.builder().usuarioMicro("jsierra").idRequest(getPrincipalRequestId())
                .traza(gsonCliente).tipo(FlowOperationEnum.VALIDATE_CLIENT).build());
    }

    private void generatePrincipalRequest(Cliente cliente) {
        PrincipalRequestPayload principalRequest = principalRequestService.insertaPrincipalRequest(
                PrincipalRequestPayload.builder()
                        .codigoAliado(cliente.getRequestHeader().getCodAliado())
                        .usuarioAliado(cliente.getRequestHeader().getUsuarioAliado())
                        .ipOrigen(cliente.getRequestHeader().getIpOrigen())
                        .json(new Gson().toJson(cliente.getRequestHeader()))
                        .build()
        );
        setPrincipalRequestId(principalRequest.getId());
    }
}