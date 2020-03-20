package co.com.santander.adapters.secondary.rest.vigia;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.VigiaProperties;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.dto.VigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.mapper.VigiaMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;
import co.com.santander.ports.secondary.solicitud.VigiaService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("vigiaServiceImpl")
public class VigiaServiceImpl extends ServiceRestAbs implements VigiaService {

    private final RestTemplateService restTemplateService;
    private final ClientesProperties properties;
    private final VigiaProperties vigiaProperties;
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
        Optional<Map<String, String>> headersMap = generateGenericsHeaders(idRequest, new Gson().toJson(PrincipalVigiaDTO
                .builder()
                .tipoIdentificacion(datosBasicosCliente.getTipoIdentificacion())
                .numeroIdentificacion(datosBasicosCliente.getNumeroIdentificacion())
                .build()));
        ResponseDto result = extractGenericResponse(restTemplateService.postWithOutParams(vigiaProperties.getUriVigia(), request, headersMap).get());
        if(result.getCodRespuesta().equalsIgnoreCase("1")){
            return buscarRespuesta(result.getRespuestaServicio());
        }
        return ListaCliente.builder().build();
    }

}
