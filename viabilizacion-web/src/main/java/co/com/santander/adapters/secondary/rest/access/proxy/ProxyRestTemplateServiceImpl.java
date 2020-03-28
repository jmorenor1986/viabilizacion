package co.com.santander.adapters.secondary.rest.access.proxy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.santander.adapters.secondary.rest.access.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.service.dto.LogPayload;
import lombok.Getter;
import lombok.Setter;

@Service("proxyRestTemplateServiceImpl")
public class ProxyRestTemplateServiceImpl implements RestTemplateService {

    private RestTemplateService restTemplateService;
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
    public ProxyRestTemplateServiceImpl(@Qualifier("restTemplateServiceImpl") RestTemplateService restTemplateService
            , LogService logService
            , FilterLogMapper filterLogMapper) {
        this.restTemplateService = restTemplateService;
        this.logService = logService;
        this.filterLogMapper = filterLogMapper;
    }

    @Override
    public Optional<String> getWithPathParams(String uri, List<String> pathParams, Optional<Map<String, String>> headers) {
        generateLog(uri,pathParams, headers);
        Optional<String> rta = restTemplateService.getWithPathParams(uri, pathParams, headers);
        logResponse(rta.get());
        return rta.isPresent() ? rta : Optional.empty();
    }

    @Override
    public Optional<String> postWithOutParams(String uri, Object request, Optional<Map<String, String>> headers) {
        generateLog(uri,request, headers);
        Optional<String> rta = restTemplateService.postWithOutParams(uri, request, headers);
        logResponse(rta.get());
        return rta.isPresent() ? rta : Optional.empty();
    }

    @Override
    public Optional<String> getWithOutParams(String uri, Object request, Optional<Map<String, String>> headers) {
        generateLog(uri,request, headers);
        Optional<String> rta = restTemplateService.getWithOutParams(uri, request, headers);
        logResponse(rta.get());
        return rta.isPresent() ? rta : Optional.empty();
    }

    @Override
    public Optional<String> getWithParams(String uri, Map<String, Object> params, Optional<Map<String, String>> headers) {
        generateLog(uri,params, headers);
        Optional<String> rta = restTemplateService.getWithParams(uri, params, headers);
        logResponse(rta.get());
        return rta.isPresent() ? rta : Optional.empty();
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

}
