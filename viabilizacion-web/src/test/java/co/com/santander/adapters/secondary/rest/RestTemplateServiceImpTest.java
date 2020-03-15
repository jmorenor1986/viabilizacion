package co.com.santander.adapters.secondary.rest;

import co.com.santander.adapters.secondary.rest.common.HttpRequestInterceptor;
import co.com.santander.ports.primary.log.LogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
public class RestTemplateServiceImpTest {
    public static final String URI = "http://localhost:1234/validacion/v1/ciudad/";
    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private RestTemplateService restTemplateService;
    @Mock
    private HttpRequestInterceptor httpRequestInterceptor;
    private RestTemplateBuilder restTemplateBuilder;
    @Mock
    private ClientHttpRequestFactory factory;
    private Map<String, String> map;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void init() {
        restTemplateBuilder = new RestTemplateBuilder();
        factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        MockitoAnnotations.initMocks(this);
        restTemplateService = new RestTemplateServiceImpl(factory, httpRequestInterceptor );
        map = new HashMap<>();
        map.put("idHeader", "123456789");
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithPathParams() {
        Optional<String> result = restTemplateService.getWithPathParams(URI, new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), null);
    }

    @Test(expected = RestClientException.class)
    public void testPostWithOutParams() {
        Optional<String> result = restTemplateService.postWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = RestClientException.class)
    public void testGetWithOutParams() {
        Optional<String> result = restTemplateService.getWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithParams() {
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("numeroId", "1");
        mapParam.put("primerApellidoBuscar", "2");
        Optional<String> result = restTemplateService.getWithParams(URI, mapParam, null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithParamsSuccess() {
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("numeroId", "1");
        mapParam.put("primerApellidoBuscar", "2");

        Map<String, String> headers = new HashMap<>();
        mapParam.put("idRequest", "123");

        Optional<String> result = restTemplateService.getWithParams(URI, mapParam, Optional.of(headers));
    }

}
