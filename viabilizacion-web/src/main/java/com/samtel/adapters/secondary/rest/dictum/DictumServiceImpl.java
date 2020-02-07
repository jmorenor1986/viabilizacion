package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.config.ClientesProperties;
import com.samtel.ports.secondary.solicitud.DictumService;

public class DictumServiceImpl implements DictumService {
    public DictumServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, DictumXMLMapper dictumXMLMapper) {
    }
}
