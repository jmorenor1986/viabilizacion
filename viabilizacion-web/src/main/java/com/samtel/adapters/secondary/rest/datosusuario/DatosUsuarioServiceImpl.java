package com.samtel.adapters.secondary.rest.datosusuario;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.ReconocerProperties;
import com.samtel.domain.solicitud.datosusuario.RequestDatosUsuario;
import com.samtel.domain.solicitud.datosusuario.ResponseDatosUsuario;
import com.samtel.ports.secondary.solicitud.DatosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class DatosUsuarioServiceImpl implements DatosUsuarioService {
    private final ReconocerProperties reconocerProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final JsonUtilities jsonUtilities;


    @Autowired
    public DatosUsuarioServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.reconocerProperties = clientesProperties.getReconocerProperties();
        this.jsonUtilities = jsonUtilities;
    }


    @Override
    public ResponseDatosUsuario consultarDatosUsuario(RequestDatosUsuario requestDatosUsuario) {
        String responseService = restTemplateService.getWithParams(reconocerProperties.getUri(),
                setMapParameters(requestDatosUsuario)).get();
        return ResponseDatosUsuario.builder()
                .numeroCelular(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))
                .numerosTelefono(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


    }

    private Map<String, Object> setMapParameters(RequestDatosUsuario requestDatosUsuario) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestDatosUsuario.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestDatosUsuario.getPrimerApellido());
        map.put("tipoId", requestDatosUsuario.getTipoDocumento());
        map.put("nit", reconocerProperties.getNit());
        map.put("tipoIdBuscar", reconocerProperties.getNumeroIdBuscar());
        map.put("numeroIdBuscar", reconocerProperties.getNumeroIdBuscar());
        map.put("validarNombre", reconocerProperties.getValidarNombre());
        return map;

    }
}
