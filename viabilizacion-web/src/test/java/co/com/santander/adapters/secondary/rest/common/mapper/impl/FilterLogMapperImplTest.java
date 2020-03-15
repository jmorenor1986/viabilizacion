package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import java.net.URI;

@SpringBootTest
public class FilterLogMapperImplTest {

    private FilterLogMapperImpl filterLogMapper;
    @Mock
    private HttpRequest request;
    @Mock
    private ClientHttpResponse response;

    private ClientesProperties clientesProperties;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.filterLogMapper = new FilterLogMapperImpl(clientesProperties);
    }

    @Test
    public void testToLogRequestCiudadSuccess() {
        Mockito.when(request.getURI()).thenReturn(URI.create("http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
        Assert.assertNotNull(filterLogMapper.toLogRequest(request, "true", Long.valueOf("1")));
    }

    @Test
    public void testToLogRequestFailed() {
        Mockito.when(request.getURI()).thenReturn(URI.create("http://localhost:5000/viabilizacion/ciudad/bogota"));
        Assert.assertNotNull(filterLogMapper.toLogRequest(request, "true", Long.valueOf("1")));
    }

    @Test
    public void testToLogResponse(){
        Assert.assertNotNull(filterLogMapper.toLogResponse(response, FlowOperationEnum.VALIDATE_CITY, Long.valueOf("1"), "TRUE", "http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
    }

    @Test
    public void testToLogResponseFailed(){
        Assert.assertNotNull(filterLogMapper.toLogResponse(response, FlowOperationEnum.NO_APLICA, Long.valueOf("1"), "TRUE", "http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
    }
}