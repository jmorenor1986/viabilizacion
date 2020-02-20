package com.samtel.adapters.secondary.rest.common.mapper.impl;

import com.samtel.adapters.secondary.rest.common.mapper.FilterLogMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;

@SpringBootTest
public class FilterLogMapperImplTest {

    private FilterLogMapper filterLogMapper;
    @Mock
    private HttpRequest request;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.filterLogMapper = new FilterLogMapperImpl();
    }
    @Test
    public void testToLogRequest(){
        Assert.assertNotNull(filterLogMapper.toLogRequest(request,"true", "1234"));
    }
}
