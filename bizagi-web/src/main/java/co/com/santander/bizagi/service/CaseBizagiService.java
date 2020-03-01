package co.com.santander.bizagi.service;

import co.com.santander.bizagi.dto.RequestCreateCaseDTO;
import org.json.JSONException;

import java.net.MalformedURLException;

public interface CaseBizagiService {
    String createCaseString(RequestCreateCaseDTO request) throws MalformedURLException, JSONException;
}
