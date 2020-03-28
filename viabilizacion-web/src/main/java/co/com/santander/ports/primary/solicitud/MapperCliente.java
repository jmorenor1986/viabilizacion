package co.com.santander.ports.primary.solicitud;

import co.com.santander.adapters.primary.rest.solicitud.dto.ClientePayLoad;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.generic.GeneralPayload;

public interface MapperCliente {

    Cliente fromGeneralPayLoad(GeneralPayload<ClientePayLoad> payload);

}
