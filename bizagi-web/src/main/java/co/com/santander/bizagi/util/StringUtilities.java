package co.com.santander.bizagi.util;

import org.json.JSONException;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StringUtilities {


    public static final String REGEX_REPLACE = "&lt;";
    public static final String REPLACEMENT = "<";

    public String xmlToJson(String xmlResponse) throws JSONException {
        return Optional.ofNullable(XML.toJSONObject(
                replaceXml(xmlResponse)).toString(4)).
                orElseThrow(() -> new JSONException("Error al convertir el xml"));
    }

    private String replaceXml(String xmlResponse) {
        return xmlResponse.replace(REGEX_REPLACE, REPLACEMENT);
    }


    public String cdataToJson(String xmlResponse) {
        String response = xmlResponse.replaceAll("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "")
                .replaceAll("<!\\[CDATA\\[", "")
                .replaceAll("]]>", "");
        return response;

    }

}
