package co.com.santander.adapters.secondary.rest.dictum.mapper.impl;

import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.dictum.mapper.DictumClienteMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DictumClienteMapperImplTest {

    private DictumClienteMapper dictumClienteMapper;

    @Mock
    private RequestHeader requestHeader;
    @Mock
    private Cliente cliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dictumClienteMapper = new DictumClienteMapperImpl();
    }

    @Test
    public void testClientToRequestDictum() {
        Assert.assertNotNull(dictumClienteMapper.toRequestDictum(cliente));
    }
}
