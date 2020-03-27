package co.com.santander.core.services.solicitud;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.primary.rest.solicitud.dto.ClientePayLoad;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.ports.primary.solicitud.MapperCliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperClienteImpl implements MapperCliente {

    private ModelMapper mapper;

    @Autowired
    public MapperClienteImpl( ModelMapper mapper ) {
        this.mapper = mapper;
    }

    @Override
    public Cliente fromGeneralPayLoad(GeneralPayload<ClientePayLoad> payload) {
        Cliente cliente = mapper.map(payload.getRequestBody(), Cliente.class);
        cliente.setRequestHeader(mapper.map(payload.getRequestHeader(), RequestHeader.class));
        return cliente;
    }
}
