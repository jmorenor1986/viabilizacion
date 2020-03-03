package co.com.santander.core.services.solicitud;

import co.com.santander.adapters.secondary.database.santander.entity.PrincipalRequest;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ClienteValidator;
import co.com.santander.core.services.log.PrincipalRequestService;
import co.com.santander.ports.primary.log.LogService;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import co.com.santander.ports.secondary.database.santander.IPrincipalRequestRepository;
import co.com.santander.utils.IGenerateUniqueId;
import com.google.gson.Gson;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.core.errors.MandatoryFieldException;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final IGenerateUniqueId generateUniqueId;
    private Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);

    @Getter
    @Setter
    private Long principalRequestId;

    @Autowired
    public SolicitudServiceImpl(ClienteValidator clienteValidator, LogService logService,
                                @Qualifier("proxyLogValidateCity") ValidateRequest validateRequest, IGenerateUniqueId generateUniqueId, PrincipalRequestService principalRequestService) {
        this.clienteValidator = clienteValidator;
        this.logService = logService;
        this.validateRequest = validateRequest;
        this.generateUniqueId = generateUniqueId;
        this.principalRequestService = principalRequestService;
    }

    @Override
    public Optional<ResponseFlow> cumplimientoSolicitud(Cliente cliente) {
        log.info("Inicia solicitud de validación");
        if (clienteValidator.validateObject(cliente)) {
			generatePrincipalRequest(cliente);
            //setRequestId(generateUniqueId.generateUniqueIdStr(Long.valueOf(12)));
            generarLog(cliente);
            return validateRequest.process(cliente, getPrincipalRequestId());
        }
        throw new MandatoryFieldException("Request invalido", 400);
    }


    public void generarLog(Cliente cliente) {
        String gsonCliente = new Gson().toJson(cliente);
        logService.insertLogOperation(LogGeneral.builder().usuarioMicro("jsierra").idRequest(getPrincipalRequestId())
                .traza(gsonCliente).tipo(FlowOperationEnum.VALIDATE_CLIENT).build());
    }

    private void generatePrincipalRequest(Cliente cliente) {
        PrincipalRequest principalRequest = principalRequestService.insertaPrincipalRequest(
                PrincipalRequest.builder()
                        .codigoAliado(cliente.getRequestHeader().getCodAliado())
                        .usuarioAliado(cliente.getRequestHeader().getUsuarioAliado())
                        .ipOrigen(cliente.getRequestHeader().getIpOrigen())
                        .json(new Gson().toJson(cliente.getRequestHeader()))
                        .build()
        );
        setPrincipalRequestId(principalRequest.getId());
    }
}