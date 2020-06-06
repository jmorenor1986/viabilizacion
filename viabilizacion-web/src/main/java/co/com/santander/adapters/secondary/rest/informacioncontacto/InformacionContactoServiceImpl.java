package co.com.santander.adapters.secondary.rest.informacioncontacto;


import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.reconocer.InformacionContactoDTO;
import co.com.santander.dto.reconocer.PrincipalReconocerDTO;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("informacionContactoServiceImpl")
public class InformacionContactoServiceImpl  extends ServiceRestAbs implements InformacionContactoService {

    private final ClientesProperties clientesProperties;
    private final RestService restService;
    private final InformacionContactoMapperImpl mapper;
    @Getter @Setter
    private String tokenReconocer;

    @Autowired
    public InformacionContactoServiceImpl(@Qualifier("proxyRestServiceImpl") RestService restService
            , ClientesProperties properties
            , JsonUtilities jsonUtilities
            , InformacionContactoMapperImpl mapper
    ) {
        this.clientesProperties = properties;
        this.restService = restService;
        this.jsonUtilities = jsonUtilities;
        this.mapper = mapper;
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        Optional<ResponseDto> responseService;
        if(generateTokenServiceReconocer(cliente, idRequest)){
            GeneralPayload<InformacionContactoDTO> requestObject = mapper.dtoToRequest(informacionContacto, cliente);
            requestObject.getRequestBody().setToken(getTokenReconocer());
            try {
                responseService = restService.callService(requestObject
                        , ServicioEnum.RECONOCER
                        , generateGenericsHeaders(
                                idRequest,
                                new Gson().toJson(PrincipalReconocerDTO.builder()
                                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                                .tipoIdentificacion(cliente.getTipoIdentificacion())
                                .build())));
            }catch (Exception e){
                //Si genera alguna excepcion al llamar al servicio de reconocer retorna empty para luego llamar a ubica
                return Optional.empty();
            }
        }else{
            return Optional.empty();
        }
        if("1".equalsIgnoreCase(responseService.get().getCodRespuesta())){
            return Optional.of( buscarRespuestaReconocer(responseService.get().getRespuestaServicio()) );
        }
        return Optional.empty();
    }

    private Boolean generateTokenServiceReconocer(Cliente cliente, Long idRequest){
        GeneralPayload<String> requestToken = GeneralPayload.<String>builder()
                .requestHeader(mapper.setHeader(cliente.getRequestHeader()))
                .build();
        Optional<Map<String, String>> headersMap = CreateHeadersMap.generateMap(HeaderDto.builder()
                .key("idRequest")
                .value(idRequest.toString())
                .build());
        Optional<ResponseDto> response = restService.callService(requestToken , ServicioEnum.TOKEN_RECONOCER, headersMap);
        if(response.isPresent()){
            setTokenReconocer(extractTokenReconocer(response.get().getRespuestaServicio()));
        }else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}