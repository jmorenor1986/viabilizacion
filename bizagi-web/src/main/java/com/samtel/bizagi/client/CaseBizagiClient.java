package com.samtel.bizagi.client;

import org.tempuri.CreateCases;
import org.tempuri.CreateCasesResponse;

import java.net.MalformedURLException;

public interface CaseBizagiClient {
    CreateCasesResponse.CreateCasesResult createCase(CreateCases.CasesInfo request) throws MalformedURLException;
}
