package com.samtel.adapters.secondary.rest.common;

import com.samtel.adapters.secondary.rest.common.mapper.impl.FilterLogMapperImpl;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.ports.primary.log.LogService;
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
    private String idRequest;
    @Getter
    @Setter
    private String url;
    private FlowOperationEnum operation;

    public HttpRequestInterceptor(LogService logService) {
        this.logService = logService;
    }

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        setIdRequest(request.getHeaders().get("idRequest").stream().reduce((a, b) -> a + "" + b).orElse(""));
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        LogGeneral logEntity = FilterLogMapperImpl
                .builder()
                .build()
                .toLogRequest(request, new String(body, "UTF-8"), getIdRequest());
        operation = logEntity.getTipo();
        logService.insertLogOperation(logEntity);
        setUrl(logEntity.getUrl());
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        LogGeneral logEntity = FilterLogMapperImpl
                .builder()
                .build()
                .toLogResponse(response, operation, getIdRequest(), StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()), getUrl());
        logService.insertLogOperation(logEntity);
    }
}
