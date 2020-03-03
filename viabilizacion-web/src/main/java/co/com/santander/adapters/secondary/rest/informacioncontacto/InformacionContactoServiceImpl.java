package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.RequestInformacionContacto;
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


    @Autowired
    public InformacionContactoServiceImpl(RestTemplateService restTemplateService, ClientesProperties properties, JsonUtilities jsonUtilities) {
        this.clientesProperties = properties;
        this.restTemplateService = restTemplateService;
        this.informacionContactoProperties = clientesProperties.getInformacionContactoProperties();
        this.jsonUtilities = jsonUtilities;
    }


    @Override
    public ResponseInformacionContacto consultarDatosUsuario(InformacionContacto informacionContacto, String idRequest) {
        String responseService = restTemplateService.getWithParams(informacionContactoProperties.getReconocerProperties().getUri(),
                setMapParameters(informacionContacto), generateHeaders(idRequest)).get();
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


    }

    @Override
    public ResponseInformacionContacto consultarInformacionContacto(InformacionContacto informacionContacto, String idRequest) {
        GeneralPayload<RequestInformacionContacto> payload = mapper(informacionContacto, informacionContactoProperties);
        Optional<Map<String, String>> mapHeaders = generateHeaders(idRequest);
        Optional<String> respuesta = restTemplateService.postWithOutParams(informacionContactoProperties
                .getUbicaProperties()
                .getUri(), payload, mapHeaders);
        return setResponseInformacionContacotUbica((respuesta.isPresent()) ? respuesta.get() : "Error");
    }

    private GeneralPayload<RequestInformacionContacto> mapper(InformacionContacto informacionContacto, InformacionContactoProperties informacionContactoProperties) {
        RequestHeader requestHeader = RequestHeader.builder()
                .codAliado(informacionContacto.getCodigoAliado())
                .usuarioAliado(informacionContacto.getUsuarioAliado())
                .sesionId(informacionContacto.getSessionId())
                .ipOrigen(informacionContacto.getIpOrigen())
                .numeroSolicitudCredito(informacionContacto.getNumeroSolicitudCredito())
                .tipoIdentificacion(informacionContacto.getTipoDocumento())
                .identificacion(informacionContacto.getNumeroDocumento())
                .build();
        RequestInformacionContacto requestInformacionContacto = RequestInformacionContacto.builder()
                .primerApellido(informacionContacto.getPrimerApellido())
                .motivoConsulta(informacionContacto.getMotivoConsulta())
                .build();
        GeneralPayload<RequestInformacionContacto> result = new GeneralPayload<>();
        result.setRequestHeader(requestHeader);
        result.setRequestBody(requestInformacionContacto);
        return result;
    }

    private Map<String, Object> setMapParameters(InformacionContacto informacionContacto) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", informacionContacto.getNumeroDocumento());
        map.put("primerApellidoBuscar", informacionContacto.getPrimerApellido());
        map.put("tipoId", informacionContacto.getTipoDocumento());
        map.put("nit", informacionContactoProperties.getReconocerProperties().getNit());
        map.put("tipoIdBuscar", informacionContactoProperties.getReconocerProperties().getNumeroIdBuscar());
        map.put("numeroIdBuscar", informacionContactoProperties.getReconocerProperties().getNumeroIdBuscar());
        map.put("validarNombre", informacionContactoProperties.getReconocerProperties().getValidarNombre());
        return map;
    }

    private ResponseInformacionContacto setResponseInformacionContacotUbica(String json) {
        return ResponseInformacionContacto.builder()
                .direcciones(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Mails.Mail", "Correo", json))))
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Celulares.Celular", "Celular", json))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("respuestaServicio.CIFIN.Tercero.UbicaPlusCifin.Telefonos.Telefono", "Telefono", json))))
                .build();
    }

    public Optional<Map<String, String>> generateHeaders(String idRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", idRequest);
        return Optional.of(headers);
    }
}
