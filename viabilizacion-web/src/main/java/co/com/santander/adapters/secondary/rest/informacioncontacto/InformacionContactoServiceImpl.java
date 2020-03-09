package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.dictum.DictumServiceImpl;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InformacionContactoServiceImpl implements InformacionContactoService {
    private final InformacionContactoProperties informacionContactoProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final JsonUtilities jsonUtilities;
    private final InformacionContactoMapperImpl mapper;

    private static final Logger log= LoggerFactory.getLogger(InformacionContactoServiceImpl.class);


    @Autowired
    public InformacionContactoServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities, InformacionContactoMapperImpl mapper) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.informacionContactoProperties = clientesProperties.getInformacionContactoProperties();
        this.jsonUtilities = jsonUtilities;
        this.mapper = mapper;
    }


    @Override
    public ResponseInformacionContacto consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        String responseService = "";
        if(generateTokenServiceReconocer(cliente, idRequest)){
            responseService = restTemplateService.postWithOutParams(informacionContactoProperties.getReconocerProperties().getUri(),
                    mapper.dtoToRequest(informacionContacto, cliente), generateHeaders(idRequest)).get();
        }
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();
    }

    private Boolean generateTokenServiceReconocer(Cliente cliente, Long idRequest){
        GeneralPayload<String> requestToken = GeneralPayload.<String>builder()
                .requestHeader(mapper.setHeader(cliente.getRequestHeader()))
                .build();
        Optional<Map<String, String>> headersMap = CreateHeadersMap.generateMap(HeaderDto.builder()
                .key("idRequest")
                .value(idRequest.toString())
                .build());
        Optional<String> response = restTemplateService.postWithOutParams(informacionContactoProperties.getReconocerProperties().getUriToken(),
                requestToken, headersMap);
        if(response.isPresent()){
            extractToken(response.get());
        }
        return Boolean.TRUE;
    }

    private String extractToken(String response){
        String respuestaServicio = jsonUtilities.getObjectWithKey("respuestaServicio",response);

        log.info("Esta es el valor de la propiedad: {}", respuestaServicio);

        return "";
    }


    @Override
    public ResponseInformacionContacto consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        Optional<Map<String, String>> mapHeaders = generateHeaders(idRequest);
        Optional<String> respuesta = restTemplateService.postWithOutParams(informacionContactoProperties
                .getUbicaProperties()
                .getUri(), mapper.dtoToRequest(informacionContacto, cliente), mapHeaders);
        return setResponseInformacionContacotUbica((respuesta.isPresent()) ? respuesta.get() : "Error");
    }

    private ResponseInformacionContacto setResponseInformacionContacotUbica(String json) {
        return ResponseInformacionContacto.builder()
                .direcciones(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Mails.Mail", "Correo", json))))
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Celulares.Celular", "Celular", json))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Telefonos.Telefono", "Telefono", json))))
                .build();
    }

    public Optional<Map<String, String>> generateHeaders(Long idRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest.toString());
        return Optional.of(headers);
    }
}
