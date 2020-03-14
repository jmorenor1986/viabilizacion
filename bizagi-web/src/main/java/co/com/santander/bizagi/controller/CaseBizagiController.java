package co.com.santander.bizagi.controller;

import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.GeneralPayload;
import co.com.santander.bizagi.dto.ResponsePayLoad;
import co.com.santander.bizagi.service.CaseBizagiService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("v1/bizagi")
public class CaseBizagiController {
    private final CaseBizagiService caseBizagiService;

    @Autowired
    public CaseBizagiController(CaseBizagiService caseBizagiService) {
        this.caseBizagiService = caseBizagiService;
    }


    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneralPayload<ResponsePayLoad>> createCase(@RequestBody(required = true) GeneralPayload<Cliente> clientePayload) throws MalformedURLException, JSONException {
        ResponseEntity<GeneralPayload<ResponsePayLoad>> respuesta = new ResponseEntity<>(GeneralPayload.<ResponsePayLoad>builder()
                .requestHeader(clientePayload.getRequestHeader())
                .requestBody(ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("1"))
                        .respuestaServicio(this.caseBizagiService.createCaseString(clientePayload.getRequestBody()))
                        .mensajeError("OK")
                        .build())
                .build(),HttpStatus.OK);
        return respuesta;
    }

    @PostMapping(value = "/create-case", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse createCaseObject(@RequestBody GeneralPayload<Cliente> clientePayload) throws MalformedURLException, JSONException {
        return this.caseBizagiService.createCase(clientePayload.getRequestBody());
    }
}
