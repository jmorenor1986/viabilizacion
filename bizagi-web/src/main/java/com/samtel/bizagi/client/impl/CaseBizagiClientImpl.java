package com.samtel.bizagi.client.impl;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.common.properties.ServiciosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.CreateCases;
import org.tempuri.CreateCasesResponse;
import org.tempuri.WorkflowEngineSOA;
import org.tempuri.WorkflowEngineSOASoap;

import java.net.MalformedURLException;

@Service
public class CaseBizagiClientImpl implements CaseBizagiClient {
    private final ServiciosProperties serviciosProperties;
    private final WorkflowEngineSOA workflowEngineSOA;
    private WorkflowEngineSOASoap workflowEngineSOASoap;

    @Autowired
    public CaseBizagiClientImpl(ServiciosProperties serviciosProperties, WorkflowEngineSOA workflowEngineSOA) {
        this.serviciosProperties = serviciosProperties;
        this.workflowEngineSOA = workflowEngineSOA;
        this.workflowEngineSOASoap = workflowEngineSOA.getWorkflowEngineSOASoap();
    }

    @Override
    public CreateCasesResponse.CreateCasesResult createCase(CreateCases.CasesInfo request) throws MalformedURLException {
        return workflowEngineSOASoap.createCases(request);
    }
}
