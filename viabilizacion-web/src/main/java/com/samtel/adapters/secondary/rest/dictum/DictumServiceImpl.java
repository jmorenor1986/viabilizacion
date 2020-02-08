package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.dictum.common.DecisionDictum;
import com.samtel.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.dto.ResponseDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.config.ClientesProperties;
import com.samtel.domain.solicitud.RequestDictum;
import com.samtel.errors.XmlParsingException;
import com.samtel.ports.secondary.solicitud.DictumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public class DictumServiceImpl implements DictumService {

    public static final String ERROR_RESPONSE_NULL = "ERROR AL OBTENER LA RESPUESTA";
    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;
    private final DictumXMLMapper dictumXMLMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public DictumServiceImpl(RestTemplateService restTemplateService, ClientesProperties clientesProperties, DictumXMLMapper dictumXMLMapper, ModelMapper modelMapper) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = clientesProperties;
        this.dictumXMLMapper = dictumXMLMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<String> consultarDictum(RequestDictum request) {
        RequestDictumDTO requestDictumDTO = modelMapper.map(request, RequestDictumDTO.class);
        ResponseDictumDTO response = (ResponseDictumDTO) restTemplateService.getWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO).get();
        return consultarDecisionDictum(response);

    }

    private Optional<String> consultarDecisionDictum(ResponseDictumDTO responseDictumDTO) {
        if (Objects.nonNull(responseDictumDTO)) {
            if (Objects.nonNull(responseDictumDTO.getRespuestaServicio())) {
                return buscarRespuesta(responseDictumDTO.getRespuestaServicio());
            }
            throw new XmlParsingException(responseDictumDTO.getMensajeError());
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
}
