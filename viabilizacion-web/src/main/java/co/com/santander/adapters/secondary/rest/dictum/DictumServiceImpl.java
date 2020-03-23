package co.com.santander.adapters.secondary.rest.dictum;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.adapters.secondary.rest.dictum.dto.RequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.ports.secondary.solicitud.DictumService;

@Service("dictumServiceImpl")
public class DictumServiceImpl extends ServiceRestAbs implements DictumService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties clientesProperties;
    private final DictumMapperImpl dictumMapper;

    @Autowired
    public DictumServiceImpl(@Qualifier("proxyRestTemplateServiceImpl") RestTemplateService restTemplateService, ClientesProperties clientesProperties, DictumMapperImpl dictumMapper, JsonUtilities jsonUtilities) {
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

}
