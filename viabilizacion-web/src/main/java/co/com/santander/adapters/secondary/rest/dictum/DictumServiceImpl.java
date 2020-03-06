package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.core.errors.XmlParsingException;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
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
    private final DictumMapperImpl dictumMapper;

    @Autowired
    public DictumServiceImpl(RestTemplateService restTemplateService, ClientesProperties clientesProperties, DictumMapperImpl dictumMapper) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = clientesProperties;
        this.dictumMapper = dictumMapper;
    }

    @Override
    public Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest) {
        GeneralPayload<RequestDictumDTO> requestDictumDTO = dictumMapper.dtoToRequest(dictum, cliente);
        Optional<Map<String, String>> headersMap = generateHeaders(idRequest, requestDictumDTO);
        String response = restTemplateService.postWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO, headersMap).get();
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

    public Optional<Map<String, String>> generateHeaders(Long idRequest, GeneralPayload<RequestDictumDTO> request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest.toString());
        headers.put("idCache", new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .identificacion(request.getRequestHeader().getIdentificacion())
                .primerApellido(request.getRequestBody().getPrimerApellido())
                .tipoIdentificacion(request.getRequestHeader().getTipoIdentificacion())
                .build()));
        return Optional.of(headers);
    }
}
