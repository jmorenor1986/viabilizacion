package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.dictum.DictumServiceImpl;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InformacionContactoServiceImpl  extends ServiceRestAbs implements InformacionContactoService {

    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final InformacionContactoMapperImpl mapper;

    private String tokenReconocer;
    private static final Logger log= LoggerFactory.getLogger(InformacionContactoServiceImpl.class);


    @Autowired
    public InformacionContactoServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities, InformacionContactoMapperImpl mapper) {
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
            requestObject.getRequestBody().setToken(tokenReconocer);
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
            return Optional.of(ResponseInformacionContacto.builder()
                    .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService.getRespuestaServicio()))))
                    .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService.getRespuestaServicio()))))
                    .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService.getRespuestaServicio()))
                    .correoElectronico(jsonUtilities.getValuesForGivenKey("reporte", "emails", "dato", responseService.getRespuestaServicio()))
                    .build());
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
            tokenReconocer = extractToken(response.get());
        }else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private String extractToken(String response){
        ResponseDto responseDto = jsonUtilities.getGeneralResponse(response);
        String respuestaServicio = responseDto.getRespuestaServicio();
        //Eliminar caracteres extranios
        Integer inicio = respuestaServicio.indexOf("{");
        Integer fin = respuestaServicio.indexOf("}");
        String json = respuestaServicio.substring(inicio,fin);
        //Extraigo el valor del token
        inicio= json.indexOf("access_token=");
        fin = json.indexOf("scope=");
        String token = json.substring(inicio,fin);
        //Quitamos La propiedad
        inicio= token.indexOf("=");
        token = token.substring(inicio+1,token.length() -2);
        return token;
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
            return setResponseInformacionContacotUbica(responseService.getRespuestaServicio());
        }else{
            return Optional.empty();
        }
    }

    private Optional<ResponseInformacionContacto> setResponseInformacionContacotUbica(String json) {
        if(json.isEmpty())
            return Optional.empty();
        String objetoUbicacion = jsonUtilities.getObjectWithKey("CIFIN.Tercero.UbicaPlusCifin", json);

        List<String> correos = jsonUtilities.getValuesForGivenKey("Mails", "Mail","Correo", objetoUbicacion);
        List<String> celulares = jsonUtilities.getValuesForGivenKey("Celulares", "Celular","Celular", objetoUbicacion);
        List<String> telefonos = jsonUtilities.getValuesForGivenKey("Telefonos", "Telefono","Telefono", objetoUbicacion);

        return Optional.of( ResponseInformacionContacto.builder()
                .correoElectronico(correos)
                .numeroCelular(celulares)
                .numerosTelefono(telefonos)
                .build() );
    }


}
