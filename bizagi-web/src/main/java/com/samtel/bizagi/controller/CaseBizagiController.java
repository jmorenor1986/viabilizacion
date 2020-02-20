package com.samtel.bizagi.controller;

import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.dto.ResponseCreateCaseDTO;
import com.samtel.bizagi.service.CaseBizagiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/bizagi")
public class CaseBizagiController {
    private final CaseBizagiService caseBizagiService;

    @Autowired
    public CaseBizagiController(CaseBizagiService caseBizagiService) {
        this.caseBizagiService = caseBizagiService;
    }


    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseCreateCaseDTO createCase(@RequestBody RequestCreateCaseDTO request) {
        return this.caseBizagiService.createCase(request);
    }
}
