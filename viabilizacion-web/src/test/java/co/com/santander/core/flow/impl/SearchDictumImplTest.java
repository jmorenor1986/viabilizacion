package co.com.santander.core.flow.impl;

import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.exception.BussinesException;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.secondary.solicitud.DictumService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchDictumImplTest {

    private ValidateRequest validateRequest;

    private GenerateUniqueIdImpl generateUniqueId;

    @Mock
    private ValidateRequest next;
    @Mock
    private DictumService dictumService;
    @Mock
    private Cliente cliente;
    @Mock
    private DictumMapperImpl dictumMapper;

    private Long requestId;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        validateRequest = new SearchDictumImpl(next, dictumService);
        generateUniqueId = new GenerateUniqueIdImpl();
    }

    @Test(expected = BussinesException.class)
    public void testSearchReconocerImplSuccess() {
        requestId = Long.valueOf("1");
        String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.NEGADO).toString();
        Assert.assertNotNull(result);
    }

}
