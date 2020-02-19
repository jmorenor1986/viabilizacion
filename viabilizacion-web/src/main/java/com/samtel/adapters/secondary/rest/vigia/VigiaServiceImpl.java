package com.samtel.adapters.secondary.rest.vigia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.VigiaProperties;
import com.samtel.adapters.secondary.rest.vigia.dto.MensajeDTO;
import com.samtel.adapters.secondary.rest.vigia.dto.VigiaDTO;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ListaCliente;
import com.samtel.ports.secondary.solicitud.VigiaService;

import java.util.Optional;

@Service
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
    public ListaCliente consultarListasCliente(Cliente datosBasicosCliente, String idRequest) {
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
        String result = restTemplateService.getWithOutParams(vigiaProperties.getUriVigia(), dto, Optional.of(idRequest) ).get();
        return ListaCliente.builder()
                .resultado(jsonUtilities.getPropertyObjectWithKey("Data.", "Listas", result))
                .encontradoId(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoID", result))
                .encontradoNombre(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoNombre", result))
                .build();

    }
}
