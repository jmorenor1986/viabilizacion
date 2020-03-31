package co.com.santander.bizagi.service.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.dto.BizAgiWSParam;
import co.com.santander.bizagi.dto.Case;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.SolicitudCredito;
import co.com.santander.bizagi.service.CaseBizagiService;
import co.com.santander.bizagi.util.StringUtilities;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private final StringUtilities stringUtilities;
    private final ServiciosProperties serviciosProperties;

    @Autowired
    public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient, VelocityEngine velocityEngine, VelocityContext context,
                                 StringUtilities stringUtilities, ServiciosProperties serviciosProperties) {
        this.caseBizagiClient = caseBizagiClient;
        this.velocityEngine = velocityEngine;
        this.context = context;
        this.stringUtilities = stringUtilities;
        this.serviciosProperties = serviciosProperties;
    }

    @Override
    public String createCaseString(Cliente cliente) throws MalformedURLException, JSONException {
        String requestString = putParametersVelocity(cliente).replaceAll("\r", "");
        //System.out.println(requestString);
        return stringUtilities.xmlToJson(
                stringUtilities.cdataToJson(
                        caseBizagiClient.createCaseString(requestString)));
    }

    @Override
    public GenericResponse createCase(Cliente cliente) throws MalformedURLException, JSONException {
        BizAgiWSParam request = setParams(cliente, serviciosProperties);
        return GenericResponse.builder()
                .codRespuesta("1")
                .respuestaError("null")
                .respuestaServicio(caseBizagiClient.createCase(request))
                .build();
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

    private String putParametersVelocity(Cliente cliente) {
        Template template = velocityEngine.getTemplate(TEMPLATES_REQUEST_CREATE_CASE, "UTF-8");
        context.put("domain", serviciosProperties.getDomain());
        context.put("username", serviciosProperties.getUserName());
        context.put("process", serviciosProperties.getProcess());
        context.put("documentnumber", cliente.getNumeroIdentificacion());
        context.put("typedocument", cliente.getTipodeidentificacion());
        context.put("apellido1", cliente.getApellido1());
        context.put("apellido2", cliente.getApellido2());
        context.put("nombre1", cliente.getNombre1());
        context.put("nombre2", cliente.getNombre2());

        context.put("fechanacimiento", cliente.getFechaNacimiento());
        context.put("telefono", cliente.getTelefonoResidencia());
        context.put("celular", cliente.getCelularPersonal());
        context.put("correo", cliente.getCorreoPersonal());
        context.put("ingresosmensuales", cliente.getIngresosMensuales());
        context.put("valorvehiculo", cliente.getValorSolicitado());

        context.put("autorizaCentrales", serviciosProperties.getAutorizaConsultaaCentrales());
        StringWriter writer =  new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }
}
