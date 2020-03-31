package co.com.santander.adapters.secondary.rest.vigia.proxy;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.vigia.dto.PrincipalVigiaDTO;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ListaCliente;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import co.com.santander.ports.secondary.accesodatos.ServicioService;
import co.com.santander.ports.secondary.solicitud.VigiaService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyVigiaServiceImpl")
public class ProxyVigiaServiceImpl extends ServiceRestAbs implements VigiaService {

    private VigiaService vigiaService;
    @Getter
    @Setter
    private Cliente cliente;

    @Autowired
    public ProxyVigiaServiceImpl(@Qualifier("vigiaServiceImpl") VigiaService vigiaService,
                                 JsonUtilities jsonUtilities,
                                 ServicioService servicioService,
                                 CacheUsrService cacheUsrService) {
        this.vigiaService = vigiaService;
        this.jsonUtilities = jsonUtilities;
        this.servicioService = servicioService;
        this.cacheUsrService = cacheUsrService;
    }

    /**
     * Metodo encargado de consultar la vigencia que tiene el servicio y si el usuario implicado tiene llamado previo en la base de datos
     *
     * @param datosBasicosCliente
     * @param idRequest
     * @return
     */
    @Override
    public ListaCliente consultarListasCliente(Cliente datosBasicosCliente, Long idRequest) {
        setCliente(datosBasicosCliente);
        generateObjectCache();
        if (!consultaCacheServicio(ServicioEnum.VIGIA)) {
            return vigiaService.consultarListasCliente(datosBasicosCliente, idRequest);
        }
        ListaCliente respuesta = generateResponse();
        return respuesta != null ? respuesta : vigiaService.consultarListasCliente(datosBasicosCliente, idRequest);
    }

    private ListaCliente generateResponse() {
        Optional<String> respuesta = obtenerValorCache();
        if (respuesta.isPresent()) {
            ResponseDto result = extractGenericResponse(respuesta.get());
            if (result.getCodRespuesta().equalsIgnoreCase("1"))
                return buscarRespuesta(result.getRespuestaServicio());
        }
        return null;
    }

    private void generateObjectCache() {
        setKeyCache(new Gson().toJson(PrincipalVigiaDTO
                .builder()
                .numeroIdentificacion(getCliente().getNumeroIdentificacion())
                .tipoIdentificacion(getCliente().getTipoIdentificacion())
                .build()));
    }

}
