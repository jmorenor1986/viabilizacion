package com.samtel.dictum.service;

import com.samtel.dictum.service.impl.RestTemplateServiceImpl;
import com.samtel.dictum.service.mapper.DictumXMLMapper;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;

@SpringBootTest
public class RestTemplateServiceImplTest {

    private RestTemplateService restTemplateService;
    private RestTemplateBuilder restTemplateBuilder;
    private DictumXMLMapper dictumXMLMapper;

    @Before
    public void setUp() {
        restTemplateService = new RestTemplateServiceImpl(restTemplateBuilder);
    }
}
