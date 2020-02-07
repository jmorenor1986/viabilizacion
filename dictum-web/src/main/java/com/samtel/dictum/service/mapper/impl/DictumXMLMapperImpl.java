package com.samtel.dictum.service.mapper.impl;

import com.samtel.dictum.service.mapper.DictumXMLMapper;

import java.util.Optional;

public class DictumXMLMapperImpl implements DictumXMLMapper {
    @Override
    public Optional<String> toJsonString(String xml) {
        return Optional.empty();
    }
}
