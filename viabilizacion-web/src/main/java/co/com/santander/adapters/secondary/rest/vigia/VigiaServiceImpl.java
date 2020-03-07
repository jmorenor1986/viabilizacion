package co.com.santander.adapters.secondary.rest.vigia;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.VigiaProperties;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.dto.VigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.mapper.VigiaMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;
import co.com.santander.ports.secondary.solicitud.VigiaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class VigiaServiceImpl implements VigiaService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties properties;
    private final VigiaProperties vigiaProperties;
    private final JsonUtilities jsonUtilities;
    private final VigiaMapperImpl vigiaMapper;

    @Autowired
    public VigiaServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities, VigiaMapperImpl vigiaMapper) {
        this.restTemplateService = restTemplateService;
        this.properties = properties;
        this.vigiaProperties = properties.getVigiaProperties();
        this.jsonUtilities = jsonUtilities;
        this.vigiaMapper = vigiaMapper;
    }

    @Override
    public ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest) {
        GeneralPayload<VigiaDTO> request = vigiaMapper.dtoToRequest(vigiaProperties, datosBasicosCliente);
        Optional<Map<String, String>> headersMap = generateHeaders(idRequest, request);
        String result = restTemplateService.postWithOutParams(vigiaProperties.getUriVigia(), request, headersMap).get();
        return ListaCliente.builder()
                .resultado(jsonUtilities.getPropertyObjectWithKey("Data.", "Listas", result))
                .encontradoId(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoID", result))
                .encontradoNombre(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoNombre", result))
                .build();

    }


    public Optional<Map<String, String>> generateHeaders(Long idRequest, GeneralPayload<VigiaDTO> request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest.toString());
        headers.put("idCache", new Gson().toJson(PrincipalVigiaDTO
                .builder()
                .nombre(request.getRequestBody().getNombre())
                .numeroIdentificacion(request.getRequestHeader().getIdentificacion())
                .build()));
        return Optional.of(headers);
    }
}
