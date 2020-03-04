package co.com.santander.adapters.secondary.rest.vigia;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.VigiaProperties;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.dto.VigiaDTO;
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

    @Autowired
    public VigiaServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.restTemplateService = restTemplateService;
        this.properties = properties;
        this.vigiaProperties = properties.getVigiaProperties();
        this.jsonUtilities = jsonUtilities;

    }

    @Override
    public ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest) {
        GeneralPayload<VigiaDTO> request = mapper(datosBasicosCliente);
        Optional<Map<String, String>> headersMap = generateHeaders(idRequest, request);
        String result = restTemplateService.postWithOutParams(vigiaProperties.getUriVigia(), request, headersMap).get();
        return ListaCliente.builder()
                .resultado(jsonUtilities.getPropertyObjectWithKey("Data.", "Listas", result))
                .encontradoId(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoID", result))
                .encontradoNombre(jsonUtilities.getPropertyObjectWithKey("Data.", "EncontradoNombre", result))
                .build();

    }

    private GeneralPayload<VigiaDTO> mapper(Cliente datosBasicosCliente) {
        VigiaDTO dto = VigiaDTO.builder().porcentaje(vigiaProperties.getPorcentaje()).nombre(datosBasicosCliente.getApellidos()
                .concat(" ")
                .concat(datosBasicosCliente.getNombres()))
                .build();
        GeneralPayload<VigiaDTO> result = new GeneralPayload<>();
        result.setRequestHeader(RequestHeader.builder()
                .codAliado(datosBasicosCliente.getRequestHeader().getCodAliado())
                .usuarioAliado(datosBasicosCliente.getRequestHeader().getUsuarioAliado())
                .sesionId(datosBasicosCliente.getRequestHeader().getSesionId())
                .ipOrigen(datosBasicosCliente.getRequestHeader().getIpOrigen())
                .numeroSolicitudCredito(datosBasicosCliente.getRequestHeader().getNumeroSolicitudCredito())
                .tipoIdentificacion(datosBasicosCliente.getRequestHeader().getTipoIdentificacion())
                .identificacion(datosBasicosCliente.getRequestHeader().getTipoIdentificacion())
                .build());
        result.setRequestBody(dto);
        return result;

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
