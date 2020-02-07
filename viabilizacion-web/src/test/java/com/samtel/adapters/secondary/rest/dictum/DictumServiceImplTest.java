package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.adapters.secondary.rest.dto.RequestDictum;
import com.samtel.config.ClientesProperties;
import com.samtel.ports.secondary.solicitud.DictumService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DictumServiceImplTest {
    private DictumService dictumService;
    private ClientesProperties properties;
    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";

    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private DictumXMLMapper dictumXMLMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriDictum(URI);
        dictumService = new DictumServiceImpl(restTemplateService, properties, dictumXMLMapper);
    }

    @Test
    public void testDictumSuccess() {
        RequestDictum request = new RequestDictum();
    }
}
