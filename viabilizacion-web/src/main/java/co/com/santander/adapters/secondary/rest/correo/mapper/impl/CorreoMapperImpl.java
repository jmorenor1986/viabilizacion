package co.com.santander.adapters.secondary.rest.correo.mapper.impl;

import co.com.santander.adapters.secondary.rest.correo.mapper.CorreoMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.mail.CustomerPayload;
import co.com.santander.dto.mail.MailPayload;
import org.springframework.stereotype.Service;

@Service
public class CorreoMapperImpl implements CorreoMapper {

    @Override
    public GeneralPayload<MailPayload> dtoToRequest(Cliente cliente) {
        MailPayload body = MailPayload.builder()
                .decision(cliente.getDecision())
                .emailTO(cliente.getCorreoElectronico())
                .numberRequest(cliente.getRequestHeader().getNumeroSolicitudCredito())
                .customer(CustomerPayload.builder()
                        .firstName(cliente.getNombres())
                        .lastName(cliente.getApellidos())
                        .build()
                )
                .build();
        GeneralPayload<MailPayload> result = GeneralPayload.<MailPayload>builder()
                .requestHeader(cliente.getRequestHeader())
                .requestBody(body)
                .build();
        return result;
    }
}
