package com.samtel.bizagi.client.impl;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.common.properties.ServiciosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseBizagiClientImpl implements CaseBizagiClient {
    private final ServiciosProperties serviciosProperties;

    @Autowired
    public CaseBizagiClientImpl(ServiciosProperties serviciosProperties) {
        this.serviciosProperties = serviciosProperties;
    }

    @Override
    public Object createCase(Object request) {
        //TODO Create consume service
        return new Object();
    }
}
