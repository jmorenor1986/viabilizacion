package co.com.santander.bizagi.service.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.util.StringUtilities;
import co.com.santander.bizagi.dto.RequestCreateCaseDTO;
import co.com.santander.bizagi.service.CaseBizagiService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.net.MalformedURLException;

@Service
public class CaseBizagiServiceImpl implements CaseBizagiService {
    public static final String TEMPLATES_REQUEST_CREATE_CASE = "templates/requestCreateCase.vm";
    private final CaseBizagiClient caseBizagiClient;
    private final VelocityEngine velocityEngine;
    private final VelocityContext context;
    private final StringWriter stringWriter;
    private final StringUtilities stringUtilities;

    @Autowired
    public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient, VelocityEngine velocityEngine, VelocityContext context, StringWriter stringWriter, StringUtilities stringUtilities) {
        this.caseBizagiClient = caseBizagiClient;
        this.velocityEngine = velocityEngine;
        this.context = context;
        this.stringWriter = stringWriter;
        this.stringUtilities = stringUtilities;
    }

    @Override
    public String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException, JSONException {
        String requestString = putParametersVelocity(request).replaceAll("\r", "");
        return stringUtilities.xmlToJson(
                stringUtilities.cdataToJson(
                        caseBizagiClient.createCaseString(requestString)));
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