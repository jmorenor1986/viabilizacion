package com.samtel.adapters.secondary.rest;

import com.samtel.adapters.secondary.rest.interceptor.HttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .additionalInterceptors(Collections.singletonList(new HttpRequestInterceptor()))
                .build();
    }

    @Override
    public ResponseEntity<String> getWithPathParams(String uri, List<String> pathParams) {
        uri = uri.concat(String.join("/", pathParams));
        HttpEntity<Object> request = new HttpEntity<>(addHeaders());        
        return restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
    }

    @Override
    public Optional<Object> postWithOutParams(String uri, Object objectRequest) {
        HttpEntity<Object> request = new HttpEntity<>(objectRequest, addHeaders());
        return Optional.ofNullable(restTemplate.exchange(uri, HttpMethod.POST, request, String.class).getBody());
    }

    @Override
    public Optional<String> getWithOutParams(String uri, Object objectRequest) {
        HttpEntity<Object> request = new HttpEntity<>(objectRequest, new HttpHeaders());
        return Optional.ofNullable(restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody());
    }

    private HttpHeaders addHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
