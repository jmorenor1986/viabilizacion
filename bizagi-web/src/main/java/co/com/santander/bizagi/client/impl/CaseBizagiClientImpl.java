package co.com.santander.bizagi.client.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public String createCaseString(String request) throws MalformedURLException {
        return workflowEngineSOASoap.createCasesAsString(request);
    }
}
