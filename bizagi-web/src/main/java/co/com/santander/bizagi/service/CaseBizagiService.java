package co.com.santander.bizagi.service;

import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.dto.Cliente;
import org.json.JSONException;

import java.net.MalformedURLException;

public interface CaseBizagiService {
    String createCaseString(Cliente cliente) throws MalformedURLException, JSONException;

    GenericResponse createCase(Cliente cliente) throws MalformedURLException, JSONException;
}
