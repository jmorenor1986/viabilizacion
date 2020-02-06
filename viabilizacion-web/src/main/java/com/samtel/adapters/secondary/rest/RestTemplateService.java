package com.samtel.adapters.secondary.rest;

import java.util.Optional;

public interface RestTemplateService {

    public Optional<String> get(String uri, Object Request);
}
