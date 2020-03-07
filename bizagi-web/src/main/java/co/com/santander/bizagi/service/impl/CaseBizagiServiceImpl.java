package co.com.santander.bizagi.service.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.dto.*;
import co.com.santander.bizagi.service.CaseBizagiService;
import co.com.santander.bizagi.util.StringUtilities;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.CreateCasesResponse;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CaseBizagiServiceImpl implements CaseBizagiService {
    public static final String TEMPLATES_REQUEST_CREATE_CASE = "templates/requestCreateCase.vm";
    private final CaseBizagiClient caseBizagiClient;
    private final VelocityEngine velocityEngine;
    private final VelocityContext context;
    private final StringWriter stringWriter;
    private final StringUtilities stringUtilities;
    private final ServiciosProperties serviciosProperties;

    @Autowired
    public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient, VelocityEngine velocityEngine, VelocityContext context,
                                 StringWriter stringWriter, StringUtilities stringUtilities, ServiciosProperties serviciosProperties) {
        this.caseBizagiClient = caseBizagiClient;
        this.velocityEngine = velocityEngine;
        this.context = context;
        this.stringWriter = stringWriter;
        this.stringUtilities = stringUtilities;
        this.serviciosProperties = serviciosProperties;
    }

    @Override
    public String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException, JSONException {
        String requestString = putParametersVelocity(request).replaceAll("\r", "");
        return stringUtilities.xmlToJson(
                stringUtilities.cdataToJson(
                        caseBizagiClient.createCaseString(requestString)));
    }

    @Override
    public CreateCasesResponse.CreateCasesResult createCase(Cliente cliente) throws MalformedURLException, JSONException {
        BizAgiWSParam request = setParams(cliente, serviciosProperties);
        return caseBizagiClient.createCase(request);


    }

    private BizAgiWSParam setParams(Cliente cliente, ServiciosProperties serviciosProperties) {
        return BizAgiWSParam.builder()
                .domain(serviciosProperties.getDomain())
                .userName(serviciosProperties.getUserName())
                .Case(setCase(cliente))
                .build();
    }

    private List<Case> setCase(Cliente cliente) {
        List<Case> result = new ArrayList<>();
        result.add(Case.builder()
                .Entities(setSolicitudCredito(cliente))
                .Process(serviciosProperties.getProcess())
                .build());
        return result;
    }

    private List<SolicitudCredito> setSolicitudCredito(Cliente cliente) {
        List<SolicitudCredito> result = new ArrayList<>();
        result.add(SolicitudCredito.builder()
                .AutorizaConsultaaCentrales(serviciosProperties.getAutorizaConsultaaCentrales())
                .cliente(cliente)
                .build());
        return result;
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
