package com.samtel.adapters.secondary.rest.common;

import com.samtel.adapters.secondary.rest.common.mapper.impl.FilterLogMapperImpl;
import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.domain.repository.entity.LogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private ILogOperationRepository logOperationRepository;
    private String idRequest;

    public HttpRequestInterceptor(ILogOperationRepository logOperationRepository) {
        this.logOperationRepository = logOperationRepository;
    }

    private static final Logger log = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        String idReques = request.getHeaders().get("idRequest").stream().reduce((a, b) -> a + "" + b).orElse("");
        LogEntity logEntity = FilterLogMapperImpl.builder().build().toLogRequest(request, idReques, new String(body, "UTF-8"));
        logOperationRepository.save(logEntity);
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("============================response begin==========================================");
        log.info("Status code  : {}", response.getStatusCode());
        log.info("Status text  : {}", response.getStatusText());
        log.info("Headers      : {}", response.getHeaders());
        log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        log.info("=======================response end=================================================");
    }
}
