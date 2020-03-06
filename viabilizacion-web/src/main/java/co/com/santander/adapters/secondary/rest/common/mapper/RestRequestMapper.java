package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.core.domain.solicitud.Cliente;

public abstract class RestRequestMapper<T, R> {

    public abstract GeneralPayload<T> dtoToRequest(R request, Cliente cliente);

    public RequestHeader setHeader(co.com.santander.core.domain.solicitud.RequestHeader requestHeader) {
        return RequestHeader.builder()
                .identificacion(requestHeader.getIdentificacion())
                .tipoIdentificacion(requestHeader.getTipoIdentificacion())
                .numeroSolicitudCredito(requestHeader.getNumeroSolicitudCredito())
                .ipOrigen(requestHeader.getIpOrigen())
                .sesionId(requestHeader.getSesionId())
                .usuarioAliado(requestHeader.getUsuarioAliado())
                .codAliado(requestHeader.getCodAliado())
                .build();
    }
}
