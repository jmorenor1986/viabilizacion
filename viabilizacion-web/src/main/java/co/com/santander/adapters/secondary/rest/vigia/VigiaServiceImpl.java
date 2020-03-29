package co.com.santander.adapters.secondary.rest.vigia;


import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.VigiaProperties;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.adapters.secondary.rest.vigia.mapper.VigiaMapperImpl;
import co.com.santander.core.common.ServicioEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.vigia.VigiaDTO;
import co.com.santander.ports.secondary.solicitud.VigiaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("vigiaServiceImpl")
public class VigiaServiceImpl extends ServiceRestAbs implements VigiaService {

    private final RestService restService;
    private final ClientesProperties properties;
    private final VigiaProperties vigiaProperties;
    private final VigiaMapperImpl vigiaMapper;

    @Autowired
    public VigiaServiceImpl(@Qualifier("proxyRestServiceImpl") RestService restService
            , ClientesProperties properties
            , JsonUtilities jsonUtilities
            , VigiaMapperImpl vigiaMapper) {
        this.restService = restService;
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
        Optional<ResponseDto> result = restService.callService(request, ServicioEnum.VIGIA, headersMap);
        if(result.isPresent() && result.get().getCodRespuesta().equalsIgnoreCase("1")){
            return buscarRespuesta(result.get().getRespuestaServicio());
        }
        return ListaCliente.builder().build();
    }
}
