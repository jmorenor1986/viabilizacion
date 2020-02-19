package com.samtel.adapters.secondary.rest;

import com.samtel.core.repository.ILogOperationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@SpringBootTest
public class RestTemplateServiceImpTest {
    public static final String URI = "http://localhost:1234/validacion/v1/ciudad/";
    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private RestTemplateService restTemplateService;

    @Mock
    private ILogOperationRepository iLogOperationRepository;
    private RestTemplateBuilder restTemplateBuilder;
    private ClientHttpRequestFactory factory;

    @Before
    public void init() {
        restTemplateBuilder = new RestTemplateBuilder();
        factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        MockitoAnnotations.initMocks(this);
        restTemplateService = new RestTemplateServiceImpl(factory, iLogOperationRepository);
    }

    @Test(expected = ResourceAccessException.class)
    public void testGetWithPathParams() {
        Optional<String> result = restTemplateService.getWithPathParams(URI, new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), Optional.of("123"));
    }

    @Test(expected = RestClientException.class)
    public void testPostWithOutParams() {
        Optional<Object> result = restTemplateService.postWithOutParams(URI, new Object(), Optional.of("123"));
    }

    @Test(expected = RestClientException.class)
    public void testGetWithOutParams() {
        Optional<String> result = restTemplateService.getWithOutParams(URI, new Object(), Optional.of("123"));
    }

    @Test(expected = RestClientException.class)
    public void testGetWithParams() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", "1");
        map.put("primerApellidoBuscar", "2");
        Optional<String> result = restTemplateService.getWithParams(URI, map, Optional.of("123"));
    }

}
