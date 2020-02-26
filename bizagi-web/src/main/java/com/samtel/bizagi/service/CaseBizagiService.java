package com.samtel.bizagi.service;

import com.samtel.bizagi.dto.RequestCreateCaseDTO;

import java.net.MalformedURLException;

public interface CaseBizagiService {
    String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException;
}
