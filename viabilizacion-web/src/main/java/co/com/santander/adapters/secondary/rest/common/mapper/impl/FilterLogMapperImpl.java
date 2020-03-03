package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.HttpRequestInterceptor;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
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
    public LogGeneral toLogRequest(HttpRequest request, String body, Long idRequest) {
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
    public LogGeneral toLogResponse(ClientHttpResponse response, FlowOperationEnum tipoOperation, Long idRequest, String body, String url) {
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
            //TODO SE DEBE CAMBIAR POR LA URL REAL NO POR EL MOCK
        }else if(uri.contains("v2/5e45638a3000002848614baa")){
            return FlowOperationEnum.INVOKE_VIGIA_REQUEST;
            //TODO SE DEBE CAMBIAR POR LA URL REAL NO POR EL MOCK
        }else if(uri.contains("v2/5e3b08212f000063e356c899")){
            return FlowOperationEnum.INVOKE_DICTUM_REQUEST;
        }
        return FlowOperationEnum.NO_APLICA;
    }

    private FlowOperationEnum validateTipoResponse(FlowOperationEnum tipoOperation ){
        if(FlowOperationEnum.VALIDATE_CITY_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.VALIDATE_CITY_RESPONSE;
        }else if(FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.INVOKE_VIGIA_RESPONSE;
        }else if(FlowOperationEnum.INVOKE_DICTUM_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.INVOKE_DICTUM_RESPONSE;
        }
        return FlowOperationEnum.NO_APLICA;
    }

    public String extractURLRequest(HttpRequest request){
        return request.getURI().toString();
    }
}
