package co.com.santander.adapters.secondary.rest.ubica;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.reconocer.PrincipalUbicaDTO;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.solicitud.UbicaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("ubicaServiceImpl")
public class UbicaServiceImpl extends ServiceRestAbs implements UbicaService {

    private final RestService restService;
    private final InformacionContactoMapperImpl mapper;

    @Autowired
    public UbicaServiceImpl(@Qualifier("restServiceImpl") RestService restService
            , JsonUtilities jsonUtilities
            , InformacionContactoMapperImpl mapper) {
        this.restService = restService;
        this.jsonUtilities = jsonUtilities;
        this.mapper = mapper;
    }

    @Override
    public Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest) {
        Optional<Map<String, String>> mapHeaders = generateGenericsHeaders(idRequest, new Gson().toJson(PrincipalUbicaDTO
                .builder()
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .build()));
        Optional<ResponseDto> respuesta = restService.callService(mapper.dtoToRequest(informacionContacto, cliente)
                , ServicioEnum.UBICA
                , mapHeaders);
        if (respuesta.isPresent()) {
            return buscarRespuestaUbica(respuesta.get().getRespuestaServicio());
        } else {
            return Optional.empty();
        }
    }
}
