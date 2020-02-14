package com.samtel.adapters.secondary.rest.vigia;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.VigiaProperties;
import com.samtel.adapters.secondary.rest.vigia.dto.MensajeDTO;
import com.samtel.adapters.secondary.rest.vigia.dto.VigiaDTO;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ListaCliente;
import com.samtel.ports.secondary.solicitud.VigiaService;
import org.springframework.beans.factory.annotation.Autowired;

public class VigiaServiceImpl implements VigiaService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties properties;
    private final VigiaProperties vigiaProperties;
    private final JsonUtilities jsonUtilities;

    @Autowired
    public VigiaServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.restTemplateService = restTemplateService;
        this.properties = properties;
        this.vigiaProperties = properties.getVigiaProperties();
        this.jsonUtilities = jsonUtilities;

    }

    @Override
    public ListaCliente consultarListasCliente(Cliente datosBasicosCliente) {
        MensajeDTO mensajeDTO = MensajeDTO.builder()
                .nombre(datosBasicosCliente.getApellidos().concat(" ").concat(datosBasicosCliente.getNombres()))
                .numeroIdentificacion(datosBasicosCliente.getNumeroIdentificacion())
                .origen(vigiaProperties.getOrigen())
                .porcentaje(vigiaProperties.getPorcentaje())
                .build();
        VigiaDTO dto = VigiaDTO.builder()
                .codigoEjecucion(vigiaProperties.getCodigoEjecucion())
                .mensaje(mensajeDTO)
                .build();
        String result = restTemplateService.getWithOutParams(vigiaProperties.getUriVigia(), dto).get();
        return ListaCliente.builder()
                .resultado(jsonUtilities.getPropertyObjectWithKey("Data.", "Listas", result))
                .build();

    }
}
