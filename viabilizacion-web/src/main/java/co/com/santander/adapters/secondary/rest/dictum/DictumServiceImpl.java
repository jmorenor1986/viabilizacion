package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.core.errors.XmlParsingException;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service("dictumServiceImpl")
public class DictumServiceImpl extends ServiceRestAbs implements DictumService {

    public static final String ERROR_RESPONSE_NULL = "ERROR AL OBTENER LA RESPUESTA";
    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;
    private final DictumMapperImpl dictumMapper;
    private static final Logger log= LoggerFactory.getLogger(DictumServiceImpl.class);

    @Autowired
    public DictumServiceImpl(RestTemplateService restTemplateService, ClientesProperties clientesProperties, DictumMapperImpl dictumMapper, JsonUtilities jsonUtilities) {
        this.restTemplateService = restTemplateService;
        this.clientesProperties = clientesProperties;
        this.dictumMapper = dictumMapper;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest) {
        GeneralPayload<RequestDictumDTO> requestDictumDTO = dictumMapper.dtoToRequest(dictum, cliente);
        Optional<Map<String, String>> headersMap = generateGenericsHeaders(idRequest, new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .valorSolicitado(cliente.getValorSolicitado())
                .ingresos(cliente.getIngresos())
                .actividadEconomica(cliente.getActividad())
                .build()));
        ResponseDto result = extractGenericResponse(restTemplateService.postWithOutParams(clientesProperties.getUriDictum(), requestDictumDTO, headersMap).get());
        if (result.getCodRespuesta().equalsIgnoreCase("1"))
            return consultarDecisionDictum(result.getRespuestaServicio());
        return Optional.empty();
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
        return Optional.of(DecisionDictum.SIN_RESPUESTA);
    }

}
