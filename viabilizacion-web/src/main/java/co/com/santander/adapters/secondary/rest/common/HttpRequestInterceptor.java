package co.com.santander.adapters.secondary.rest.common;

import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.FilterLogMapperImpl;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.ports.primary.log.LogService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private final LogService logService;
    @Getter
    @Setter
    private Long idRequest;
    @Getter
    @Setter
    private String idCache;
    @Getter
    @Setter
    private String url;

    private FlowOperationEnum operation;

    private FilterLogMapper filterLogMapper;

    public HttpRequestInterceptor(LogService logService, FilterLogMapper  filterLogMapper) {
        this.logService = logService;
        this.filterLogMapper = filterLogMapper;
    }

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        findHeadersLog(request);
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        cleanObjects();
        return response;
    }

    private void cleanObjects(){
        this.setIdCache("");
        this.setUrl("");
        this.setIdRequest(Long.valueOf("0"));
    }

    private void findHeadersLog(HttpRequest request){
        if(request.getHeaders().get("idRequest") != null){
            setIdRequest(Long.valueOf(request.getHeaders().get("idRequest").stream().reduce((a, b) -> a + "" + b).orElse("")));
        }
        if(request.getHeaders().get("idCache") != null){
            setIdCache(request.getHeaders().get("idCache").stream().reduce((a, b) -> a + "" + b).orElse(""));
        }
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        LogGeneral logEntity = filterLogMapper.toLogRequest(request, new String(body, "UTF-8"), getIdRequest());
        operation = logEntity.getTipo();
        logService.insertaLogRest(logEntity, getIdCache());
        setUrl(logEntity.getUrl());
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        LogGeneral logEntity = filterLogMapper.toLogResponse(response, operation, getIdRequest(), StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()), getUrl());
        logService.insertaLogRest(logEntity, getIdCache());
    }
}
