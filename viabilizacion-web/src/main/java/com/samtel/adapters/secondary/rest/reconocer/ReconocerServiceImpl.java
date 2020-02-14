package com.samtel.adapters.secondary.rest.reconocer;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.ReconocerProperties;
import com.samtel.domain.solicitud.reconocer.RequestReconocer;
import com.samtel.domain.solicitud.reconocer.ResponseReconocer;
import com.samtel.ports.secondary.solicitud.ReconocerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ReconocerServiceImpl implements ReconocerService {
    private final ReconocerProperties reconocerProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final JsonUtilities jsonUtilities;


    @Autowired
    public ReconocerServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.reconocerProperties = clientesProperties.getReconocerProperties();
        this.jsonUtilities = jsonUtilities;
    }


    @Override
    public ResponseReconocer consultarDatosUsuario(RequestReconocer requestReconocer) {
        String responseService = restTemplateService.getWithParams(reconocerProperties.getUri(),
                setMapParameters(requestReconocer)).get();
        return ResponseReconocer.builder()
                .numeroCelular(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))
                .numerosTelefono(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


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
}
