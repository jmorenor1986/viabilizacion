package co.com.santander.adapters.secondary.rest.informacioncontacto.mapper;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.common.mapper.RestRequestMapper;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.InformacionContactoDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import org.springframework.stereotype.Service;

@Service
public class InformacionContactoMapperImpl extends RestRequestMapper<InformacionContactoDTO, InformacionContacto> {

    @Override
    public GeneralPayload<InformacionContactoDTO> dtoToRequest(InformacionContacto request, Cliente cliente) {
        GeneralPayload<InformacionContactoDTO> result = new GeneralPayload<>();
        result.setRequestHeader(setHeader(cliente.getRequestHeader()));
        result.setRequestBody(InformacionContactoDTO.builder()
                .motivoConsulta(request.getMotivoConsulta())
                .primerApellido(request.getPrimerApellido())
                .build());
        return result;
    }
}