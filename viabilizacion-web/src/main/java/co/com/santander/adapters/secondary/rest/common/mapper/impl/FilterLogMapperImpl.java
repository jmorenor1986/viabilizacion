package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.service.dto.LogPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FilterLogMapperImpl implements FilterLogMapper {

    private final ClientesProperties clientesProperties;
    enum  REQUEST_TYPE{ REQUEST_TYPE, RESPONSE_TYPE };

    @Autowired
    public FilterLogMapperImpl(ClientesProperties clientesProperties) {
        this.clientesProperties = clientesProperties;
    }

    @Override
    public LogPayload toLogRequest(ServicioEnum tipoServicio, String body, Long idRequest) {
        return LogPayload.builder()
                .tipo(validateTipo(tipoServicio, REQUEST_TYPE.REQUEST_TYPE))
                .httpStatus(HttpStatus.OK)
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .url("")
                .build();
    }

    @Override
    public LogPayload toLogResponse(ServicioEnum tipoServicio, String body, Long idRequest) {
        return LogPayload.builder()
                .tipo(validateTipo(tipoServicio, REQUEST_TYPE.REQUEST_TYPE))
                .httpStatus(HttpStatus.OK)
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .url("")
                .build();
    }

    private FlowOperationEnum validateTipo(ServicioEnum servicio, REQUEST_TYPE type  ){
        switch (servicio){
            case VALIDATE_CITY:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.VALIDATE_CITY_REQUEST : FlowOperationEnum.VALIDATE_CITY_RESPONSE;
            case VIGIA:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.INVOKE_VIGIA_REQUEST : FlowOperationEnum.INVOKE_VIGIA_RESPONSE;
            case DICTUM:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.INVOKE_DICTUM_REQUEST : FlowOperationEnum.INVOKE_DICTUM_RESPONSE;
            case RECONOCER:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.INVOKE_RECONOCER_REQUEST : FlowOperationEnum.INVOKE_RECONOCER_RESPONSE;
            case TOKEN_RECONOCER:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.INVOKE_TOKEN_RECONOCER_REQUEST : FlowOperationEnum.INVOKE_TOKEN_RECONOCER_RESPONSE;
            case UBICA:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.INVOKE_UBICA_REQUEST : FlowOperationEnum.INVOKE_UBICA_RESPONSE;
            case BIZAGI:
                return type.equals(REQUEST_TYPE.REQUEST_TYPE) ? FlowOperationEnum.CASO_BIZAGI_REQUEST : FlowOperationEnum.CASO_BIZAGI_RESPONSE;
            default:
                return FlowOperationEnum.NO_APLICA;
        }
    }
}
