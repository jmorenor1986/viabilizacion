package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.mapper.impl.DictumMapperImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.dto.dictum.PrincipalRequestDictumDTO;
import co.com.santander.dto.dictum.RequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.constants.ServicioEnum;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("dictumServiceImpl")
public class DictumServiceImpl extends ServiceRestAbs implements DictumService {

    private final RestService restService;
    private final ClientesProperties clientesProperties;
    private final DictumMapperImpl dictumMapper;

    @Autowired
    public DictumServiceImpl(@Qualifier("proxyRestServiceImpl") RestService restService, ClientesProperties clientesProperties, DictumMapperImpl dictumMapper, JsonUtilities jsonUtilities) {
        this.restService = restService;
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
        Optional<ResponseDto> result = restService.callService(requestDictumDTO, ServicioEnum.DICTUM, headersMap);
        if (result.isPresent() && "1".equalsIgnoreCase(result.get().getCodRespuesta()))
            return consultarDecisionDictum(result.get().getRespuestaServicio());
        return Optional.empty();
    }

}
