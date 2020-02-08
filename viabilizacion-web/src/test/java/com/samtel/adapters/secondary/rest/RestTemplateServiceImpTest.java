package com.samtel.adapters.secondary.rest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class RestTemplateServiceImpTest {
    public static final String URI = "http://localhost:1234/validacion/v1/ciudad/";
    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private RestTemplateService restTemplateService;


    private RestTemplateBuilder restTemplateBuilder;


    @Before
    public void init() {
        restTemplateBuilder = new RestTemplateBuilder();
        MockitoAnnotations.initMocks(this);
        restTemplateService = new RestTemplateServiceImpl(restTemplateBuilder);
    }

    @Test(expected = ResourceAccessException.class)
    public void testGetWithPathParams() {
        Optional<String> result = restTemplateService.getWithPathParams(URI, new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)));

    }

    @Test(expected = RestClientException.class)
    public void testPostWithOutParams() {
        Optional<Object> result = restTemplateService.postWithOutParams(URI, new Object());
    }

    @Test(expected = RestClientException.class)
    public void testGetWithOutParams() {
        Optional<String> result = restTemplateService.getWithOutParams(URI, new Object());
    }
}
