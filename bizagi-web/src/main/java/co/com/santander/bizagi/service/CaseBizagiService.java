package co.com.santander.bizagi.service;

import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.RequestCreateCaseDTO;
import org.json.JSONException;
import org.tempuri.CreateCasesResponse;

import java.net.MalformedURLException;

public interface CaseBizagiService {
    String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException, JSONException;

    CreateCasesResponse.CreateCasesResult createCase(Cliente cliente) throws MalformedURLException, JSONException;
}
