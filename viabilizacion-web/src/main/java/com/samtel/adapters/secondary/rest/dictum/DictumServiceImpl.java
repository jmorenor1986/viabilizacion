package com.samtel.adapters.secondary.rest.dictum;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.dto.ResponseDictumDTO;
import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.config.ClientesProperties;
import com.samtel.domain.solicitud.RequestDictum;
import com.samtel.domain.solicitud.ResponseDictum;
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
    public Optional<ResponseDictum> consultarDictum(RequestDictum request) {
        RequestDictumDTO requestDictumDTO = modelMapper.map(request, RequestDictumDTO.class);
        ResponseDictumDTO response = (ResponseDictumDTO) restTemplateService.getWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO).get();
        return transformaRespuesta(response);

    }

    private Optional<ResponseDictum> transformaRespuesta(ResponseDictumDTO responseDictumDTO) {
        if (Objects.nonNull(responseDictumDTO)) {
            if (Objects.nonNull(responseDictumDTO.getRespuestaServicio())) {
                ResponseDictum responseDictum = modelMapper.map(responseDictumDTO, ResponseDictum.class);
                responseDictum.setRespuestaServicio(dictumXMLMapper.toJsonString(responseDictumDTO.getRespuestaServicio()).get());
                return Optional.of(responseDictum);
            }
            throw new XmlParsingException(responseDictumDTO.getMensajeError());
        }
        throw new XmlParsingException(ERROR_RESPONSE_NULL);

    }
}
