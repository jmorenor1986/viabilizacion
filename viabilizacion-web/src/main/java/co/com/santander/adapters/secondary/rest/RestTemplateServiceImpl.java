package co.com.santander.adapters.secondary.rest;

import co.com.santander.adapters.secondary.rest.common.HttpRequestInterceptor;
import co.com.santander.ports.primary.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate;
    private final LogService logService;
    private final ClientHttpRequestFactory factory;

    @Autowired
    public RestTemplateServiceImpl(ClientHttpRequestFactory factory, LogService logService) {
        this.logService = logService;
        this.factory = factory;
        this.restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new HttpRequestInterceptor(logService)));
    }

    @Override
    public Optional<String> getWithPathParams(String uri, List<String> pathParams, Optional<Map<String, String>> headers) {
        uri = uri.concat(String.join("/", pathParams));
        HttpEntity<Object> request = new HttpEntity<>((headers.isPresent()) ? addAdditionalHeader(addGenericHeaders(), headers.get()) : addGenericHeaders());
        return Optional.ofNullable(restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody());
    }

    @Override
    public Optional<Object> postWithOutParams(String uri, Object objectRequest, Optional<Map<String, String>> headers) {
        HttpEntity<Object> request = new HttpEntity<>(objectRequest, (headers.isPresent()) ? addAdditionalHeader(addGenericHeaders(), headers.get()) : addGenericHeaders());
        return Optional.ofNullable(restTemplate.exchange(uri, HttpMethod.POST, request, String.class).getBody());
    }

    @Override
    public Optional<String> getWithOutParams(String uri, Object objectRequest, Optional<Map<String, String>> headers) {
        HttpEntity<Object> request = new HttpEntity<>(objectRequest, (headers.isPresent()) ? addAdditionalHeader(new HttpHeaders(), headers.get()) : new HttpHeaders());
        return Optional.ofNullable(restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody());
    }

    @Override
    public Optional<String> getWithParams(String uri, Map<String, Object> params, Optional<Map<String, String>> headers) {
        HttpEntity<Object> request = new HttpEntity<>((headers.isPresent()) ? addAdditionalHeader(addGenericHeaders(), headers.get()) : addGenericHeaders());
        String url = setParamsUrl(uri, params);
        return Optional.ofNullable(restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody());
    }

    private HttpHeaders addGenericHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private HttpHeaders addAdditionalHeader(HttpHeaders headers, Map<String, String> cabeceras) {
        cabeceras.forEach((key, value) -> {
            headers.set(key, value);
        });
        return headers;
    }

    private String setParamsUrl(String uri, Map<String, Object> params) {
        String result = uri;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            result = setParamUrl(result, entry.getKey(), entry.getValue());
        }
        return result;
    }

    private String setParamUrl(String uri, String name, Object value) {
        return UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam(name, value)
                .toUriString();
    }
}
