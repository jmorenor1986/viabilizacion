package com.samtel.adapters.secondary.rest.reconocer;

import com.google.gson.Gson;
import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.config.properties.ClientesProperties;
import com.samtel.config.properties.ReconocerProperties;
import com.samtel.domain.solicitud.reconocer.RequestReconocer;
import com.samtel.domain.solicitud.reconocer.ResponseReconocer;
import com.samtel.ports.secondary.solicitud.ReconocerService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconocerServiceImpl implements ReconocerService {
    private final ReconocerProperties reconocerProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final Gson gson;

    @Autowired
    public ReconocerServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, Gson gson) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.reconocerProperties = clientesProperties.getReconocerProperties();
        this.gson = gson;
    }


    @Override
    public ResponseReconocer consultarDatosUsuario(RequestReconocer requestReconocer) {
        setList(restTemplateService.getWithParams(reconocerProperties.getUri(),
                setMapParameters(requestReconocer)).get());
        return gson.fromJson(restTemplateService.getWithParams(reconocerProperties.getUri(),
                setMapParameters(requestReconocer)).get(),
                ResponseReconocer.class);
    }

    private Map<String, Object> setMapParameters(RequestReconocer requestReconocer) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestReconocer.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestReconocer.getPrimerApellido());
        map.put("tipoId", requestReconocer.getTipoDocumento());
        map.put("nit", reconocerProperties.getNit());
        map.put("tipoIdBuscar", reconocerProperties.getNumeroIdBuscar());
        map.put("numeroIdBuscar", reconocerProperties.getNumeroIdBuscar());
        map.put("validarNombre", reconocerProperties.getValidarNombre());
        return map;

    }

    private List<String> setList(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject reporte = jsonObject.getJSONObject("reporte");
        System.out.println(reporte.getJSONObject("celulares"));
        return null;
    }
}
