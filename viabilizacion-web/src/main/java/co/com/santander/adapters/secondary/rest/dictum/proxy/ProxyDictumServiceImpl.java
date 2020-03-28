package co.com.santander.adapters.secondary.rest.dictum.proxy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.service.CacheUsrService;
import co.com.santander.persistencia.service.ServicioService;
import co.com.santander.ports.secondary.solicitud.DictumService;
import lombok.Getter;
import lombok.Setter;

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
        if(!consultaCacheServicio(ServicioEnum.DICTUM)){
            return dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
        }
        Optional<String> respuesta = generateResponse();
        return respuesta.isPresent() ? respuesta : dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
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

}