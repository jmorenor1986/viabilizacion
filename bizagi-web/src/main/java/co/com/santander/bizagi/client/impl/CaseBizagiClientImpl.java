package co.com.santander.bizagi.client.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.dto.BizAgiWSParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.CreateCases;
import org.tempuri.CreateCasesResponse;
import org.tempuri.WorkflowEngineSOA;
import org.tempuri.WorkflowEngineSOASoap;

import java.net.MalformedURLException;
import java.util.Collections;

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
    public String createCaseString(String request) throws MalformedURLException {
        return workflowEngineSOASoap.createCasesAsString(request);
    }

    @Override
    public CreateCasesResponse.CreateCasesResult createCase(BizAgiWSParam request) throws MalformedURLException {
        CreateCases.CasesInfo casesInfo = new CreateCases.CasesInfo();
        casesInfo.setContent(Collections.singletonList(request));
        return workflowEngineSOASoap.createCases(casesInfo);
    }
}
