package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.common.mapper.RestRequestMapper;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import org.springframework.stereotype.Service;

@Service
public class DictumMapperImpl extends RestRequestMapper<RequestDictumDTO, Dictum> {
    @Override
    public GeneralPayload<RequestDictumDTO> dtoToRequest(Dictum request, Cliente cliente) {
        GeneralPayload<RequestDictumDTO> result = new GeneralPayload<>();
        result.setRequestHeader(setHeader(cliente.getRequestHeader()));
        result.setRequestBody(RequestDictumDTO.builder()
                .clave(request.getClave())
                .parametros(request.getParametros())
                .primerApellido(request.getPrimerApellido())
                .producto(request.getProducto())
                .usuario(request.getUsuario())
                .build());
        return result;
    }
}
