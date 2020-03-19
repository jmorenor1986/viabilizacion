package co.com.santander.adapters.secondary.rest.dictum.proxy;

import co.com.santander.adapters.secondary.rest.dictum.dto.PrincipalRequestDictumDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.ports.secondary.solicitud.DictumService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyDictumServiceImpl")
public class ProxyDictumServiceImpl implements DictumService {

    private DictumService dictumService;
    @Getter @Setter
    private Cliente cliente;
    @Getter @Setter
    private String keyCache;

    @Autowired
    public ProxyDictumServiceImpl(@Qualifier("dictumServiceImpl") DictumService dictumService) {
        this.dictumService = dictumService;
    }

    @Override
    public Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest) {
        setCliente(cliente);
        generateObjectCache();
        if(consultaCacheServicio()){
            return dictumService.consultarSolicitudDictum(cliente,dictum,idRequest);
        }
        return obtenerValorCache();
    }

    public void generateObjectCache(){
        setKeyCache(new Gson().toJson(PrincipalRequestDictumDTO
                .builder()
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .valorSolicitado(cliente.getValorSolicitado())
                .ingresos(cliente.getIngresos())
                .actividadEconomica(cliente.getActividad())
                .build()));
    }

    public Boolean consultaCacheServicio(){
        //Obetenemos el objeto con el cual se va ha validar el cache


    }

    public Optional<String> obtenerValorCache(){
        //Obtenemos el valor del cache para el usuario
    }

}

