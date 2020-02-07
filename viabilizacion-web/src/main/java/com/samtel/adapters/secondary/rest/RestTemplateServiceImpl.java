package com.samtel.adapters.secondary.rest;

import com.samtel.adapters.secondary.rest.interceptor.HttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
    public Optional<String> getWithPathParams(String uri, List<String> pathParams) {
        pathParams.forEach((x) -> uri.concat("/").concat(x));
        HttpEntity<Object> request = new HttpEntity<>(addHeaders());
        return Optional.of(restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody());
    }

    private HttpHeaders addHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
