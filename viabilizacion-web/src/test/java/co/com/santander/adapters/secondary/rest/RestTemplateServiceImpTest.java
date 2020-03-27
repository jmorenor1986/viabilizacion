package co.com.santander.adapters.secondary.rest;

import co.com.santander.adapters.secondary.rest.access.RestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
public class RestTemplateServiceImpTest {
    public static final String URI = "http://localhost:1234/validacion/v1/ciudad/";
    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private RestService restService;

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
        restService = new RestTemplateServiceImpl(factory );
        map = new HashMap<>();
        map.put("idHeader", "123456789");
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithPathParams() {
        Optional<String> result = restService.getWithPathParams(URI, new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), null);
    }

    @Test(expected = NullPointerException.class)
    public void testPostWithOutParams() {
        Optional<String> result = restService.postWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithOutParams() {
        Optional<String> result = restService.getWithOutParams(URI, new Object(), Optional.of(map));
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithParams() {
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("numeroId", "1");
        mapParam.put("primerApellidoBuscar", "2");
        Optional<String> result = restService.getWithParams(URI, mapParam, null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetWithParamsSuccess() {
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("numeroId", "1");
        mapParam.put("primerApellidoBuscar", "2");

        Map<String, String> headers = new HashMap<>();
        mapParam.put("idRequest", "123");

        Optional<String> result = restService.getWithParams(URI, mapParam, Optional.of(headers));
    }

}
