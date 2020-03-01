package co.com.santander.bizagi.client;

import java.net.MalformedURLException;

public interface CaseBizagiClient {

    String createCaseString(String request) throws MalformedURLException;
}
