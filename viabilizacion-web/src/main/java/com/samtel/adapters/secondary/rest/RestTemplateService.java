package com.samtel.adapters.secondary.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface RestTemplateService {

    public ResponseEntity<String> getWithPathParams(String uri, List<String> pathParams);

    public Optional<Object> postWithOutParams(String uri, Object request);

    public Optional<String> getWithOutParams(String uri, Object request);
}
