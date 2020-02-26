package co.com.santander.adapters.secondary.rest.dictum.mapper.impl;

import co.com.santander.errors.XmlParsingException;
import co.com.santander.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DictumXMLMapperImpl implements DictumXMLMapper {

    public static final String ERROR_XML_EXCEPTION = "ERROR AL CONVERTIR EL XML DE RESPUESTA";

    @Override
    public Optional<String> toJsonString(String xml) {
        try {
            JSONObject result = XML.toJSONObject(xml);
            return Optional.ofNullable(result.toString());
        } catch (JSONException jex) {
            throw new XmlParsingException(ERROR_XML_EXCEPTION);
        }
    }
}