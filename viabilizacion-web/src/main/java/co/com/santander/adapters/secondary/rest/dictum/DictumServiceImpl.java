package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import co.com.santander.core.domain.solicitud.dictum.RequestDictum;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class DictumServiceImpl implements DictumService {

    public static final String ERROR_RESPONSE_NULL = "ERROR AL OBTENER LA RESPUESTA";
    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;
    private final ModelMapper modelMapper;

    @Autowired
    public DictumServiceImpl(RestTemplateService restTemplateService, ClientesProperties clientesProperties, ModelMapper modelMapper) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = clientesProperties;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<String> consultarSolicitudDictum(RequestDictum request, String idRequest) {
        GeneralPayload<RequestDictumDTO> requestDictumDTO = mapper(request);
        Optional<Map<String, String>> headersMap = generateHeaders(idRequest, requestDictumDTO);
        String response = restTemplateService.getWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO, headersMap).get();
        return consultarDecisionDictum(response);
    }

    private Optional<String> consultarDecisionDictum(String responseDictumDTO) {
        if (Objects.nonNull(responseDictumDTO)) {
            return buscarRespuesta(responseDictumDTO);
        }
        return Optional.of(ERROR_RESPONSE_NULL);
    }

    private Optional<String> buscarRespuesta(String xml) {
        if (xml.contains(DecisionDictum.PREAPROBADO_CON_DOCUMENTOS))
            return Optional.of(DecisionDictum.PREAPROBADO_CON_DOCUMENTOS);
        if (xml.contains(DecisionDictum.PREAPROBADO_SIN_DOCUMENTOS))
            return Optional.of(DecisionDictum.PREAPROBADO_SIN_DOCUMENTOS);
        if (xml.contains(DecisionDictum.APROBADO))
            return Optional.of(DecisionDictum.APROBADO);
        if (xml.contains(DecisionDictum.ERROR_EN_PROCESO))
            return Optional.of(DecisionDictum.ERROR_EN_PROCESO);
        if (xml.contains(DecisionDictum.NEGADO))
            return Optional.of(DecisionDictum.NEGADO);
        return Optional.of(ERROR_RESPONSE_NULL);
    }

    public Optional<Map<String, String>> generateHeaders(String idRequest, GeneralPayload<RequestDictumDTO> request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest);
        headers.put("idCache", new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .identificacion(request.getRequestHeader().getIdentificacion())
                .primerApellido(request.getRequestBody().getPrimerApellido())
                .tipoIdentificacion(request.getRequestHeader().getTipoIdentificacion())
                .build()));
        return Optional.of(headers);
    }

    private GeneralPayload<RequestDictumDTO> mapper(RequestDictum request) {
        RequestDictumDTO result = new RequestDictumDTO();
        result.setClave(request.getRequestBody().getClave());
        result.setParametros(request.getRequestBody().getParametros());
        result.setPrimerApellido(request.getRequestBody().getPrimerApellido());
        result.setProducto(request.getRequestBody().getProducto());
        result.setUsuario(request.getRequestBody().getUsuario());
        GeneralPayload<RequestDictumDTO> response = new GeneralPayload<>();
        response.setRequestBody(result);
        response.setRequestHeader(request.getRequestHeader());
        return response;
    }

}
