package com.samtel.core.flow;

import com.samtel.core.SearchCacheImpl;
import com.samtel.core.SearchReconocerImpl;
import com.samtel.domain.solicitud.RequestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchReconocerImplTest {

    private ValidateRequest validateRequest;
    @Mock
    private ValidateRequest next;

    private RequestData data;

    @Before
    public void setUp(){
        validateRequest = new SearchReconocerImpl();
        MockitoAnnotations.initMocks(this);
        data = new RequestData();
        data.setData("Esto esa una prueba");
    }

    @Test
    public void testSearchReconocerImplSuccess(){
        Boolean result = validateRequest.process(data).orElse(Boolean.FALSE);
        Assert.assertEquals(result, Boolean.TRUE);
    }
    @Test
    public void testData(){
        Assert.assertNotNull(data.getData());
    }
}