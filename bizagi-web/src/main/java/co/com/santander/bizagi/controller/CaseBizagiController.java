package co.com.santander.bizagi.controller;

import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.RequestCreateCaseDTO;
import co.com.santander.bizagi.service.CaseBizagiService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.CreateCasesResponse;

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
    public String createCase(@RequestBody RequestCreateCaseDTO request) throws MalformedURLException, JSONException {
        return this.caseBizagiService.createCaseString(request);
    }

    @PostMapping(value = "/create-case", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateCasesResponse.CreateCasesResult createCaseObject(@RequestBody Cliente cliente) throws MalformedURLException, JSONException {
        return this.caseBizagiService.createCase(cliente);
    }
}
