package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FilterLogMapperImpl implements FilterLogMapper {

    private final ClientesProperties clientesProperties;
    private final JsonUtilities jsonUtilities;

    enum  REQUEST_TYPE{ REQUEST_TYPE, RESPONSE_TYPE };

    @Autowired
    public FilterLogMapperImpl(ClientesProperties clientesProperties, JsonUtilities jsonUtilities) {
        this.clientesProperties = clientesProperties;
        this.jsonUtilities = jsonUtilities;
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
                .tipo(validateTipo(tipoServicio, REQUEST_TYPE.RESPONSE_TYPE))
                .httpStatus(evaluateResponse(body))
                .idRequest(idRequest)
                //TODO Se debe poner el usuario logeado
                .usuarioMicro("jsierra")
                .traza(body)
                .url("")
                .build();
    }
    //Metodo que evalua la respuesta enviada ya que puede ser fallida pero el estatus http correcto
    public HttpStatus evaluateResponse(String body){
        ResponseDto rta = jsonUtilities.getGeneralResponse(body);
        if(!"1".equals(rta.getCodRespuesta())){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
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
