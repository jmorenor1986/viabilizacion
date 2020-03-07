package co.com.santander.adapters.secondary.rest.vigia.mapper;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.common.mapper.RestRequestMapper;
import co.com.santander.adapters.secondary.rest.common.properties.VigiaProperties;
import co.com.santander.adapters.secondary.rest.vigia.dto.VigiaDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import org.springframework.stereotype.Service;

@Service
public class VigiaMapperImpl extends RestRequestMapper<VigiaDTO, VigiaProperties> {
    @Override
    public GeneralPayload<VigiaDTO> dtoToRequest(VigiaProperties request, Cliente cliente) {
        GeneralPayload<VigiaDTO> result = new GeneralPayload<>();
        result.setRequestHeader(setHeader(cliente.getRequestHeader()));
        result.setRequestBody(VigiaDTO.builder()
                .porcentaje(request.getPorcentaje())
                .nombre(cliente.getNombres())
                .build());
        return result;
    }
}
