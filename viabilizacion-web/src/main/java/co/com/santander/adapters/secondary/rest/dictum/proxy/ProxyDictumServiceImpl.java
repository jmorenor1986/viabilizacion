package co.com.santander.adapters.secondary.rest.dictum.proxy;

import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import co.com.santander.adapters.secondary.database.santander.entity.ServicioEntity;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.core.services.log.CacheUsrService;
import co.com.santander.core.services.log.ServicioService;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyDictumServiceImpl")
public class ProxyDictumServiceImpl extends ServiceRestAbs implements DictumService {

    private static final Logger log= LoggerFactory.getLogger(ProxyDictumServiceImpl.class);

    private DictumService dictumService;
    private ServicioService servicioService;
    private CacheUsrService cacheUsrService;
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
        if(!consultaCacheServicio()){
            return dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
        }
        return generateResponse();
    }

    private Optional<String> generateResponse(){
        Optional<String> respuesta = obtenerValorCache();
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

    private Boolean consultaCacheServicio(){
        //Obetenemos el objeto con el cual se va ha validar el cache
        Optional<ServicioEntity> servicio = servicioService.findServiceByService(ServicioEnum.DICTUM);
        if(servicio.isPresent()){
            //Valido si el tiempo es superior a 0
            setVigencia(servicio.get().getVigencia());
            if(getVigencia().compareTo(Long.valueOf(0)) > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private Optional<String> obtenerValorCache(){
        Optional<String> traza = cacheUsrService.validityLogUser(getKeyCache(),getVigencia());
        if(traza.isPresent()){
            return Optional.of(traza.get());
        }
        return Optional.empty();
    }

}

