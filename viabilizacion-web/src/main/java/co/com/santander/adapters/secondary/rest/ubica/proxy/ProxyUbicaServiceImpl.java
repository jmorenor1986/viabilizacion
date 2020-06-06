package co.com.santander.adapters.secondary.rest.ubica.proxy;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.reconocer.PrincipalUbicaDTO;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import co.com.santander.ports.secondary.accesodatos.ServicioService;
import co.com.santander.ports.secondary.solicitud.UbicaService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("proxyUbicaServiceImpl")
public class ProxyUbicaServiceImpl extends ServiceRestAbs implements UbicaService {

    private final UbicaService ubicaService;
    @Getter @Setter
    private Cliente cliente;

    @Autowired
    public ProxyUbicaServiceImpl(@Qualifier("ubicaServiceImpl") UbicaService ubicaService
            , JsonUtilities jsonUtilities
            , ServicioService servicioService
            , CacheUsrService cacheUsrService) {
        this.ubicaService = ubicaService;
        this.servicioService = servicioService;
        this.cacheUsrService = cacheUsrService;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        setCliente(cliente);
        generateObjectCacheUbica();
        GeneralPayload<ServicioEnum> general = GeneralPayload.<ServicioEnum>builder()
                .requestHeader(cliente.getRequestHeader())
                .requestBody(ServicioEnum.UBICA)
                .build();
        if (!consultaCacheServicio(general)) {
            return ubicaService.consultarInformacionContacto(cliente, informacionContacto, idRequest);
        }
        Optional<ResponseInformacionContacto> respuesta = generateResponseUbica();
        return respuesta.isPresent() ? respuesta : ubicaService.consultarInformacionContacto(cliente, informacionContacto, idRequest);
    }

    private void generateObjectCacheUbica() {
        setKeyCache(new Gson().toJson(PrincipalUbicaDTO
                .builder()
                .numeroIdentificacion(getCliente().getNumeroIdentificacion())
                .tipoIdentificacion(getCliente().getTipoIdentificacion())
                .build()));
    }

    private Optional<ResponseInformacionContacto> generateResponseUbica(){
        Optional<String> respuesta = obtenerValorCache(FlowOperationEnum.INVOKE_UBICA_RESPONSE);
        if(respuesta.isPresent()){
            ResponseDto result = extractGenericResponse(respuesta.get());
            if ("1".equalsIgnoreCase(result.getCodRespuesta()))
                return buscarRespuestaUbica(result.getRespuestaServicio());
        }
        return Optional.empty();
    }
}
