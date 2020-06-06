package co.com.santander.adapters.secondary.rest.dictum.proxy;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.dto.dictum.PrincipalRequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import co.com.santander.ports.secondary.accesodatos.ServicioService;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyDictumServiceImpl")
public class ProxyDictumServiceImpl extends ServiceRestAbs implements DictumService {

    private DictumService dictumService;

    @Getter @Setter
    private Cliente cliente;
    @Getter @Setter
    private String keyCache;
    @Getter @Setter
    private Long vigencia;

    @Autowired
    public ProxyDictumServiceImpl(@Qualifier("dictumServiceImpl") DictumService dictumService, ServicioService servicioService,
                                  CacheUsrService cacheUsrService, JsonUtilities jsonUtilities) {
        this.dictumService = dictumService;
        this.servicioService = servicioService;
        this.cacheUsrService = cacheUsrService;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest) {
        setCliente(cliente);
        generateObjectCache();
        GeneralPayload<ServicioEnum> general = GeneralPayload.<ServicioEnum>builder()
                .requestHeader(cliente.getRequestHeader())
                .requestBody(ServicioEnum.DICTUM)
                .build();
        if(!consultaCacheServicio(general)){
            return dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
        }
        Optional<String> respuesta = generateResponse();
        return respuesta.isPresent() ? respuesta : dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
    }

    private Optional<String> generateResponse(){
        Optional<String> respuesta = obtenerValorCache(FlowOperationEnum.INVOKE_DICTUM_RESPONSE);
        if(respuesta.isPresent()){
            ResponseDto result = extractGenericResponse(respuesta.get());
            if (result.getCodRespuesta().equalsIgnoreCase("1"))
                return consultarDecisionDictum(result.getRespuestaServicio());
        }
        return Optional.empty();
    }

    private void generateObjectCache(){
        setKeyCache(new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .valorSolicitado(cliente.getValorSolicitado())
                .ingresos(cliente.getIngresos())
                .actividadEconomica(cliente.getActividad())
                .build()));
    }

}