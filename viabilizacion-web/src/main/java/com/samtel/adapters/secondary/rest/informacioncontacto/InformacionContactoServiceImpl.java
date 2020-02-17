package com.samtel.adapters.secondary.rest.informacioncontacto;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import com.samtel.domain.solicitud.datosusuario.RequestInformacionContacto;
import com.samtel.domain.solicitud.datosusuario.ResponseInformacionContacto;
import com.samtel.ports.secondary.solicitud.InformacionContactoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InformacionContactoServiceImpl implements InformacionContactoService {
    private final InformacionContactoProperties informacionContactoProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final JsonUtilities jsonUtilities;


    @Autowired
    public InformacionContactoServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.informacionContactoProperties = clientesProperties.getInformacionContactoProperties();
        this.jsonUtilities = jsonUtilities;
    }


    @Override
    public ResponseInformacionContacto consultarDatosUsuario(RequestInformacionContacto requestInformacionContacto) {
        String responseService = restTemplateService.getWithParams(informacionContactoProperties.getReconocerProperties().getUri(),
                setMapParameters(requestInformacionContacto)).get();
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


    }

    @Override
    public ResponseInformacionContacto consultarInformacionContacto(RequestInformacionContacto requestInformacionContacto) {
        return null;
    }

    private Map<String, Object> setMapParameters(RequestInformacionContacto requestInformacionContacto) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestInformacionContacto.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestInformacionContacto.getPrimerApellido());
        map.put("tipoId", requestInformacionContacto.getTipoDocumento());
        map.put("nit", informacionContactoProperties.getReconocerProperties().getNit());
        map.put("tipoIdBuscar", informacionContactoProperties.getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", informacionContactoProperties.getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", informacionContactoProperties.getReconocerProperties().getValidarNombre());
        return map;

    }
}
