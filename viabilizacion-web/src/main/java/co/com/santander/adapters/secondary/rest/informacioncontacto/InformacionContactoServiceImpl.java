package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.RequestUbicaDTO;
import co.com.santander.domain.solicitud.informacioncontacto.RequestInformacionContacto;
import co.com.santander.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
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
    public ResponseInformacionContacto consultarDatosUsuario(RequestInformacionContacto requestInformacionContacto, String idRequest) {
        String responseService = restTemplateService.getWithParams(informacionContactoProperties.getReconocerProperties().getUri(),
                setMapParameters(requestInformacionContacto), generateHeaders(idRequest)).get();
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.celulares", "celular", responseService))))
                .numerosTelefono(Arrays.asList(new String(jsonUtilities.getPropertyObjectWithKey("reporte.telefonos", "telefono", responseService))))
                .direcciones(jsonUtilities.getValuesForGivenKey("reporte", "direcciones", "dato", responseService))
                .build();


    }

    @Override
    public ResponseInformacionContacto consultarInformacionContacto(RequestInformacionContacto requestInformacionContacto, String idRequest) {
        RequestUbicaDTO requestUbicaDTO = RequestUbicaDTO.builder()
                .codigoInformacion(informacionContactoProperties.getUbicaProperties().getCodigoInformacion())
                .motivoConsulta(informacionContactoProperties.getUbicaProperties().getMotivoConsulta())
                .numeroIdentificacion(requestInformacionContacto.getNumeroDocumento())
                .primerApellido(requestInformacionContacto.getPrimerApellido())
                .tipoIdentificacion(requestInformacionContacto.getTipoDocumento())
                .build();
        Optional<Map<String, String>> mapHeaders = generateHeaders(idRequest);
        Optional<String> respuesta = restTemplateService.getWithOutParams(informacionContactoProperties
                .getUbicaProperties()
                .getUri(), requestUbicaDTO, mapHeaders);
        return setResponseInformacionContacotUbica( ( respuesta.isPresent() )? respuesta.get() : "Error");
    }

    private Map<String, Object> setMapParameters(RequestInformacionContacto requestInformacionContacto) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("numeroId", requestInformacionContacto.getNumeroDocumento());
        map.put("primerApellidoBuscar", requestInformacionContacto.getPrimerApellido());
        map.put("tipoId", requestInformacionContacto.getTipoDocumento());
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
