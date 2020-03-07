package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InformacionContactoServiceImpl implements InformacionContactoService {
    private final InformacionContactoProperties informacionContactoProperties;
    private final ClientesProperties clientesProperties;
    private final RestTemplateService restTemplateService;
    private final JsonUtilities jsonUtilities;
    private final InformacionContactoMapperImpl mapper;


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
        String responseService = restTemplateService.postWithOutParams(informacionContactoProperties.getReconocerProperties().getUri(),
                mapper.dtoToRequest(informacionContacto, cliente), generateHeaders(idRequest)).get();
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


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
