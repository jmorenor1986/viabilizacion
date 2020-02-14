package com.samtel.adapters.secondary.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RestTemplateService {

    public Optional<String> getWithPathParams(String uri, List<String> pathParams);

    public Optional<Object> postWithOutParams(String uri, Object request);

    public Optional<String> getWithOutParams(String uri, Object request);

    public Optional<String> getWithParams(String uri, Map<String, Object> params);

}
