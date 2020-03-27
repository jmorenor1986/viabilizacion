package co.com.santander.adapters.secondary.rest.access.proxy;

import java.util.Map;
import java.util.Optional;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.constants.ServicioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.persistencia.constants.FlowOperationEnum;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.service.dto.LogPayload;
import lombok.Getter;
import lombok.Setter;

@Service("proxyRestServiceImpl")
public class ProxyRestTemplateServiceImpl implements RestService {

    private RestService restService;
    private LogService logService;
    private FilterLogMapper filterLogMapper;

    @Getter @Setter
    private Long idRequest;
    @Getter @Setter
    private String idCache;
    @Getter @Setter
    private Optional<Map<String, String>> headers;
    @Getter @Setter
    private String uri;
    @Getter @Setter
    private String body;
    @Getter @Setter
    private FlowOperationEnum operation;


    @Autowired
    public ProxyRestTemplateServiceImpl(@Qualifier("restServiceImpl") RestService restService
            , LogService logService
            , FilterLogMapper filterLogMapper) {
        this.restService = restService;
        this.logService = logService;
        this.filterLogMapper = filterLogMapper;
    }


    private void generateLog(String uri, Object body, Optional<Map<String, String>> headers ){
        setHeaders(headers);
        setUri(uri);
        setBody(new Gson().toJson(body));

        findHeadersLog();
        logRequest();
    }

    private void logResponse(String body) {
        LogPayload logEntity = filterLogMapper.toLogResponse(getOperation(), getIdRequest(), body, getUri());
        logService.insertaLogRest(logEntity, getIdCache());
    }

    private void logRequest(){
    	LogPayload logEntity = filterLogMapper.toLogRequest(getUri(), getBody() , getIdRequest());
        setOperation( logEntity.getTipo() );
        logService.insertaLogRest(logEntity, getIdCache());
    }

    private void findHeadersLog(){
        if(getHeaders().isPresent()){
            if(getHeaders().get().get("idRequest") != null ){
                setIdRequest(Long.valueOf(getHeaders().get().get("idRequest")));
            }
            if(getHeaders().get().get("idCache") != null ){
                setIdCache(getHeaders().get().get("idCache"));
            }
        }
    }

    @Override
    public Optional<ResponseDto> callService(GeneralPayload request, ServicioEnum servicio, Optional<Map<String, String>> cache) {
        generateLog(uri,request, cache);
        Optional<ResponseDto> rta = restService.callService(request, servicio, cache);
        logResponse(new Gson().toJson(rta.get()));
        return rta.isPresent() ? rta : Optional.empty();
    }
}
