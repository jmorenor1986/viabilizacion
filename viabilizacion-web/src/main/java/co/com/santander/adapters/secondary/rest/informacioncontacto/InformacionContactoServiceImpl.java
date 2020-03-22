package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.access.RestTemplateService;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.InformacionContactoDTO;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.PrincipalReconocerDTO;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.PrincipalUbicaDTO;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("informacionContactoServiceImpl")
public class InformacionContactoServiceImpl  extends ServiceRestAbs implements InformacionContactoService {

    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final InformacionContactoMapperImpl mapper;
    @Getter @Setter
    private String tokenReconocer;

    @Autowired
    public InformacionContactoServiceImpl(@Qualifier("proxyRestTemplateServiceImpl") RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities, InformacionContactoMapperImpl mapper) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.jsonUtilities = jsonUtilities;
        this.mapper = mapper;
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        ResponseDto responseService = new ResponseDto();
        if(generateTokenServiceReconocer(cliente, idRequest)){
            GeneralPayload<InformacionContactoDTO> requestObject = mapper.dtoToRequest(informacionContacto, cliente);
            requestObject.getRequestBody().setToken(getTokenReconocer());
            String responseServiceString = "";
            try {
                responseServiceString = restTemplateService.postWithOutParams(clientesProperties.getReconocerProperties().getUri(),
                        requestObject, generateGenericsHeaders(idRequest,new Gson().toJson(PrincipalReconocerDTO.builder()
                                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                                .tipoIdentificacion(cliente.getTipoIdentificacion())
                                .build()))).get();
            }catch (Exception e){
                //Si genera alguna excepcion al llamar al servicio de reconocer retorna empty para luego llamar a ubica
                return Optional.empty();
            }
            responseService = extractGenericResponse(responseServiceString);
        }else{
            return Optional.empty();
        }
        if("1".equalsIgnoreCase(responseService.getCodRespuesta())){
            return Optional.of( buscarRespuestaReconocer(responseService.getRespuestaServicio()) );
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
        Optional<String> response = restTemplateService.postWithOutParams(clientesProperties.getReconocerProperties().getUriToken(),
                requestToken, headersMap);
        if(response.isPresent()){
            setTokenReconocer(extractTokenReconocer(response.get()));
        }else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        ResponseDto responseService = new ResponseDto();
        Optional<Map<String, String>> mapHeaders = generateGenericsHeaders(idRequest, new Gson().toJson(PrincipalUbicaDTO
                .builder()
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .build()));
        Optional<String> respuesta = restTemplateService.postWithOutParams(clientesProperties.getUbicaProperties().getUri()
                , mapper.dtoToRequest(informacionContacto, cliente)
                , mapHeaders);
        if(respuesta.isPresent()){
            responseService = extractGenericResponse(respuesta.get());
            return buscarRespuestaUbica(responseService.getRespuestaServicio());
        }else{
            return Optional.empty();
        }
    }
}