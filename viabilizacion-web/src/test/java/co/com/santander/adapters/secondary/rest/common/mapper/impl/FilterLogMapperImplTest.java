package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.domain.repository.entity.FlowOperationEnum;
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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.filterLogMapper = FilterLogMapperImpl.builder().build();
    }

    @Test
    public void testToLogRequestCiudadSuccess() {
        Mockito.when(request.getURI()).thenReturn(URI.create("http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
        Assert.assertNotNull(filterLogMapper.toLogRequest(request, "true", "1234"));
    }

    @Test
    public void testToLogRequestFailed() {
        Mockito.when(request.getURI()).thenReturn(URI.create("http://localhost:5000/viabilizacion/ciudad/bogota"));
        Assert.assertNotNull(filterLogMapper.toLogRequest(request, "true", "1234"));
    }

    @Test
    public void testToLogResponse(){
        Assert.assertNotNull(filterLogMapper.toLogResponse(response, FlowOperationEnum.VALIDATE_CITY, "1234", "TRUE", "http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
    }

    @Test
    public void testToLogResponseFailed(){
        Assert.assertNotNull(filterLogMapper.toLogResponse(response, FlowOperationEnum.NO_APLICA, "1234", "TRUE", "http://localhost:5000/viabilizacion/v1/ciudad/bogota"));
    }
}