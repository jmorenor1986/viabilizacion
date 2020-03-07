package co.com.santander.bizagi.client;

import co.com.santander.bizagi.dto.BizAgiWSParam;
import org.tempuri.CreateCasesResponse;

import java.net.MalformedURLException;

public interface CaseBizagiClient {

    String createCaseString(String request) throws MalformedURLException;

    CreateCasesResponse.CreateCasesResult createCase(BizAgiWSParam request) throws MalformedURLException;
}
