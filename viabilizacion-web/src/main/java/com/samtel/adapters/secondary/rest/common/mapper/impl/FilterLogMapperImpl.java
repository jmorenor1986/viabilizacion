package com.samtel.adapters.secondary.rest.common.mapper.impl;

import com.samtel.adapters.secondary.rest.common.HttpRequestInterceptor;
import com.samtel.adapters.secondary.rest.common.mapper.FilterLogMapper;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.repository.entity.LogEntity;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

@Builder
public class FilterLogMapperImpl implements FilterLogMapper {

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public LogEntity toLogRequest(HttpRequest request,String body, String idRequest) {
        return LogEntity.builder()
                .tipo(validateTipoRequest(request.getURI().toString()))
                .httpStatus(HttpStatus.OK)
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .build();
    }

    @Override
    public LogEntity toLogResponse(HttpRequest request, FlowOperationEnum tipoOperation, String idRequest) {
        return null;
    }

    private FlowOperationEnum validateTipoRequest(String uri ){
        if(uri.contains("/v1/ciudad")){
            return FlowOperationEnum.VALIDATE_CITY_REQUEST;
        }
        return FlowOperationEnum.NO_APLICA;
    }

    private FlowOperationEnum validateTipoResponse(FlowOperationEnum tipoOperation ){
        if(FlowOperationEnum.VALIDATE_CITY_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.VALIDATE_CITY_RESPONSE;
        }
        return FlowOperationEnum.NO_APLICA;
    }
}
