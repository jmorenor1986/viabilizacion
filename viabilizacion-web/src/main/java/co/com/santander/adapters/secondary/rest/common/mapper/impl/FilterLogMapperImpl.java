package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.HttpRequestInterceptor;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class FilterLogMapperImpl implements FilterLogMapper {

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    private final ClientesProperties clientesProperties;

    @Autowired
    public FilterLogMapperImpl(ClientesProperties clientesProperties) {
        this.clientesProperties = clientesProperties;
    }

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
        if(uri.contains(clientesProperties.getUriValidarCiudad())){
            return FlowOperationEnum.VALIDATE_CITY_REQUEST;
        }else if(uri.contains(clientesProperties.getVigiaProperties().getUriVigia())){
            return FlowOperationEnum.INVOKE_VIGIA_REQUEST;
        }else if(uri.contains(clientesProperties.getUriDictum())){
            return FlowOperationEnum.INVOKE_DICTUM_REQUEST;
        }else if(uri.contains(clientesProperties.getReconocerProperties().getUri())){
            return FlowOperationEnum.INVOKE_RECONOCER_REQUEST;
        }else if(uri.contains(clientesProperties.getUriBizagi())){
            return FlowOperationEnum.CASO_BIZAGI_REQUEST;
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
        }else if(FlowOperationEnum.INVOKE_RECONOCER_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.INVOKE_RECONOCER_RESPONSE;
        }else if(FlowOperationEnum.CASO_BIZAGI_REQUEST.equals(tipoOperation)){
            return FlowOperationEnum.CASO_BIZAGI_RESPONSE;
        }
        return FlowOperationEnum.NO_APLICA;
    }

    public String extractURLRequest(HttpRequest request){
        return request.getURI().toString();
    }
}
