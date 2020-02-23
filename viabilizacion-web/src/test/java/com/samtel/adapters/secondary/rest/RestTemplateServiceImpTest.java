package com.samtel.adapters.secondary.rest;

import com.samtel.ports.primary.log.LogService;
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

import java.util.*;

@SpringBootTest
public class RestTemplateServiceImpTest {
    public static final String URI = "http://localhost:1234/validacion/v1/ciudad/";
    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private RestTemplateService restTemplateService;

    @Mock
    private LogService logService;
    private RestTemplateBuilder restTemplateBuilder;
    private ClientHttpRequestFactory factory;
    private Map<String, String> map;

    @Before
    public void init() {
        restTemplateBuilder = new RestTemplateBuilder();
        factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        MockitoAnnotations.initMocks(this);
        restTemplateService = new RestTemplateServiceImpl(factory, logService);
        map = new HashMap<>();
        map.put("", "");
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithPathParams() {
        Optional<String> result = restTemplateService.getWithPathParams(URI, new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), Optional.of(map));
    }

    @Test(expected = RestClientException.class)
    public void testPostWithOutParams() {
        Optional<Object> result = restTemplateService.postWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = RestClientException.class)
    public void testGetWithOutParams() {
        Optional<String> result = restTemplateService.getWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithParams() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", "1");
        map.put("primerApellidoBuscar", "2");
        Optional<String> result = restTemplateService.getWithParams(URI, map, Optional.of(this.map));
    }

}
