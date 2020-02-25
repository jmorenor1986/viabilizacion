package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import com.google.gson.Gson;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.domain.solicitud.dictum.RequestDictum;
import co.com.santander.errors.XmlParsingException;
import co.com.santander.ports.secondary.solicitud.DictumService;
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
        RequestDictumDTO requestDictumDTO = modelMapper.map(request, RequestDictumDTO.class);
        Optional<Map<String, String>> headersMap = generateHeaders(idRequest, requestDictumDTO);
        String response = restTemplateService.getWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO, headersMap).get();
        return consultarDecisionDictum(response);
    }

    private Optional<String> consultarDecisionDictum(String responseDictumDTO) {
        if (Objects.nonNull(responseDictumDTO)) {
            return buscarRespuesta(responseDictumDTO);
        }
        throw new XmlParsingException(ERROR_RESPONSE_NULL);
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

    public Optional<Map<String, String>> generateHeaders(String idRequest, RequestDictumDTO request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest);
        headers.put("idCache", new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .identificacion(request.getRequestBody().getIdentificacion())
                .primerApellido(request.getRequestBody().getPrimerApellido())
                .tipoIdentificacion(request.getRequestBody().getTipoIdentificacion())
                .build()));
        return Optional.of(headers);
    }

}
