package co.com.santander.adapters.secondary.rest.correo;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.correo.mapper.CorreoMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.mail.MailPayload;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.solicitud.EnvioCorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorreoServiceImpl implements EnvioCorreoService {

    private final RestService restService;
    private final CorreoMapper correoMapper;


    @Autowired
    public CorreoServiceImpl(@Qualifier("proxyRestServiceImpl") RestService restService, CorreoMapper correoMapper) {
        this.restService = restService;
        this.correoMapper = correoMapper;
    }

    @Override
    public Optional<String> envioCorreo(Cliente cliente, Long idRequest) {
        GeneralPayload<MailPayload> request = correoMapper.dtoToRequest(cliente);
        restService.callService(request, ServicioEnum.EMAIL_SENDER,null);
        return Optional.empty();
    }
}