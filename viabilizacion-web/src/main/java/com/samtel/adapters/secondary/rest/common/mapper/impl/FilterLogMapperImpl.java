package com.samtel.adapters.secondary.rest.common.mapper.impl;

import com.samtel.adapters.secondary.rest.common.HttpRequestInterceptor;
import com.samtel.adapters.secondary.rest.common.mapper.FilterLogMapper;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

@Builder
public class FilterLogMapperImpl implements FilterLogMapper {

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public LogGeneral toLogRequest(HttpRequest request, String body, String idRequest) {
        return LogGeneral.builder()
                .tipo(validateTipoRequest(extractURLRequest(request)))
                .httpStatus(HttpStatus.OK)
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .url(extractURLRequest(request))
                .build();
    }

    @Override
    public LogGeneral toLogResponse(ClientHttpResponse response, FlowOperationEnum tipoOperation, String idRequest, String body, String url) {
        return LogGeneral.builder()
                .tipo(validateTipoResponse(tipoOperation))
                .httpStatus(HttpStatus.OK)
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .url(url)
                .build();
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

    public String extractURLRequest(HttpRequest request){
        return request.getURI().toString();
    }
}
