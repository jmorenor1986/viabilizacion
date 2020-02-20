package com.samtel.bizagi.service.impl;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.dto.ResponseCreateCaseDTO;
import com.samtel.bizagi.service.CaseBizagiService;
import org.springframework.beans.factory.annotation.Autowired;

public class CaseBizagiServiceImpl implements CaseBizagiService {
    private final CaseBizagiClient caseBizagiClient;

    @Autowired
    public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient) {
        this.caseBizagiClient = caseBizagiClient;
    }

    @Override
    public ResponseCreateCaseDTO createCase(RequestCreateCaseDTO requestCreateCaseDTO) {
        return (ResponseCreateCaseDTO) caseBizagiClient.createCase(requestCreateCaseDTO);
    }
}
