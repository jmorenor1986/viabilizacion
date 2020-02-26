package com.samtel.bizagi.client;

import com.samtel.bizagi.dto.RequestCreateCaseDTO;

import java.net.MalformedURLException;

public interface CaseBizagiClient {

    String createCaseString(String request) throws MalformedURLException;
}
