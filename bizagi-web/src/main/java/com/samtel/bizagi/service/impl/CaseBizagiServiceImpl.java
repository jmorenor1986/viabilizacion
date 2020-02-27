package com.samtel.bizagi.service.impl;

import com.samtel.bizagi.client.CaseBizagiClient;
import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.service.CaseBizagiService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringWriter;
import java.net.MalformedURLException;

public class CaseBizagiServiceImpl implements CaseBizagiService {
    public static final String TEMPLATES_REQUEST_CREATE_CASE = "templates/requestCreateCase.vm";
    private final CaseBizagiClient caseBizagiClient;
    private final VelocityEngine velocityEngine;
    private final VelocityContext context;
    private final StringWriter stringWriter;

    @Autowired
    public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient, VelocityEngine velocityEngine, VelocityContext context, StringWriter stringWriter) {
        this.caseBizagiClient = caseBizagiClient;
        this.velocityEngine = velocityEngine;
        this.context = context;
        this.stringWriter = stringWriter;
    }

    @Override
    public String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException {
        String requestString = putParametersVelocity(request).replaceAll("\r", "");
        return caseBizagiClient.createCaseString(requestString);
    }

    private String putParametersVelocity(RequestCreateCaseDTO request) {
        Template template = velocityEngine.getTemplate(TEMPLATES_REQUEST_CREATE_CASE, "UTF-8");
        context.put("domain", request.getDomain());
        context.put("username", request.getUserName());
        context.put("process", request.getProcess());
        context.put("documentnumber", request.getDocumentNumber());
        context.put("typedocument", request.getTypeDocument());
        context.put("buroscore", request.getBuroScore());
        template.merge(context, stringWriter);
        return stringWriter.toString();
    }
}
