package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.persistencia.constants.FlowOperationEnum;
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
        this.clientesProperties = new ClientesProperties();
        this.clientesProperties.setUriValidarCiudad("http://localhost:5001/validacion/v1/ciudad/");
        this.filterLogMapper = new FilterLogMapperImpl(clientesProperties);
    }

}