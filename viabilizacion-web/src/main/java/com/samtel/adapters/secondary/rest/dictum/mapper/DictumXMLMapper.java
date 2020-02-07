package com.samtel.adapters.secondary.rest.dictum.mapper;

import java.util.Optional;

public interface DictumXMLMapper {

    public Optional<String> toJsonString(String xml);
}
