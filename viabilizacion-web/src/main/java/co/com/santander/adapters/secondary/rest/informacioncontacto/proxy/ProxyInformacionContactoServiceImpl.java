package co.com.santander.adapters.secondary.rest.informacioncontacto.proxy;

import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.PrincipalReconocerDTO;
import co.com.santander.adapters.secondary.rest.informacioncontacto.dto.PrincipalUbicaDTO;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.core.services.log.CacheUsrService;
import co.com.santander.core.services.log.ServicioService;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyInformacionContactoServiceImpl")
public class ProxyInformacionContactoServiceImpl extends ServiceRestAbs implements InformacionContactoService {

    private InformacionContactoService informacionContactoService;
    @Getter
    @Setter
    private Cliente cliente;

    @Autowired
    public ProxyInformacionContactoServiceImpl(@Qualifier("informacionContactoServiceImpl") InformacionContactoService informacionContactoService
            , JsonUtilities jsonUtilities
            , ServicioService servicioService
            , CacheUsrService cacheUsrService) {
        this.informacionContactoService = informacionContactoService;
        this.jsonUtilities = jsonUtilities;
        this.servicioService = servicioService;
        this.cacheUsrService = cacheUsrService;
    }

    //Proxy para reconocer
    @Override
    public Optional<ResponseInformacionContacto> consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        setCliente(cliente);
        generateObjectCacheReconocer();
        if (!consultaCacheServicio(ServicioEnum.RECONOCER)) {
            return informacionContactoService.consultarDatosUsuario(cliente, informacionContacto, idRequest);
        }
        ResponseInformacionContacto respuesta = generateResponseReconocer();
        return respuesta != null ? Optional.of(respuesta) : informacionContactoService.consultarDatosUsuario(cliente, informacionContacto, idRequest);
    }

    private ResponseInformacionContacto generateResponseReconocer(){
        Optional<String> respuesta = obtenerValorCache();
        if(respuesta.isPresent()){
            ResponseDto result = extractGenericResponse(respuesta.get());
            if (result.getCodRespuesta().equalsIgnoreCase("1"))
                return buscarRespuestaReconocer(result.getRespuestaServicio());
        }
        return null;
    }

    private void generateObjectCacheReconocer() {
        setKeyCache(new Gson().toJson(PrincipalReconocerDTO.builder()
                .numeroIdentificacion(getCliente().getNumeroIdentificacion())
                .tipoIdentificacion(getCliente().getTipoIdentificacion())
                .build()));
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        setCliente(cliente);
        generateObjectCacheUbica();
        if (!consultaCacheServicio(ServicioEnum.UBICA)) {
            return informacionContactoService.consultarInformacionContacto(cliente, informacionContacto, idRequest);
        }
        Optional<ResponseInformacionContacto> respuesta = generateResponseUbica();
        return respuesta.isPresent() ? respuesta : informacionContactoService.consultarInformacionContacto(cliente, informacionContacto, idRequest);
    }

    private void generateObjectCacheUbica() {
        setKeyCache(new Gson().toJson(PrincipalUbicaDTO
                .builder()
                .numeroIdentificacion(getCliente().getNumeroIdentificacion())
                .tipoIdentificacion(getCliente().getTipoIdentificacion())
                .build()));
    }

    private Optional<ResponseInformacionContacto> generateResponseUbica(){
        Optional<String> respuesta = obtenerValorCache();
        if(respuesta.isPresent()){
            ResponseDto result = extractGenericResponse(respuesta.get());
            if (result.getCodRespuesta().equalsIgnoreCase("1"))
                return buscarRespuestaUbica(result.getRespuestaServicio());
        }
        return Optional.empty();
    }

}