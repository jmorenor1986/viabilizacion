package co.com.santander.adapters.secondary.rest.correo.mapper;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.mail.MailPayload;

public interface CorreoMapper {

    GeneralPayload<MailPayload> dtoToRequest(Cliente cliente);

}
