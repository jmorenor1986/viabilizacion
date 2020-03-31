package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.clients.viabilizacion.LogClient;
import co.com.santander.clients.viabilizacion.ServicioClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.LogServicePayload;
import co.com.santander.dto.viabilizacion.ServicioPayload;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.secondary.accesodatos.LogService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    private final LogClient logClient;
    private final ServicioClient servicioClient;
    private final ModelMapper mapper;

    @Autowired
    public LogServiceImpl(LogClient logClient, ServicioClient servicioClient, ModelMapper mapper) {
        this.logClient = logClient;
        this.servicioClient = servicioClient;
        this.mapper = mapper;
    }

    @Override
    public Boolean insertLogOperation(GeneralPayload<LogPayload> log) {
        ResponseDto rta = logClient.insertLogOperation(log).getBody();
        return Boolean.TRUE;
    }

    @Override
    public Boolean insertaLogRest(GeneralPayload<LogPayload> log, String idCache) {
        if(validateEspecificCacheService(log.getRequestBody().getTipo())){
            Optional<Long> idServicio = getIdServicio(validaServicio(log.getRequestBody().getTipo()), log.getRequestHeader());
            if(idServicio.isPresent()){
                LogServicePayload logService = LogServicePayload.builder()
                        .idCache(idCache)
                        .log(log.getRequestBody())
                        .idServicio(idServicio.get())
                        .build();

                GeneralPayload<LogServicePayload> logGeneralPayload = GeneralPayload.<LogServicePayload>builder()
                        .requestHeader(log.getRequestHeader())
                        .requestBody(logService)
                        .build();
                ResponseDto respuesta = logClient.insertaLogRest(logGeneralPayload).getBody();
                System.out.println(idServicio.get());
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Optional<Long> getIdServicio(ServicioEnum servicio, RequestHeader header){
        GeneralPayload<ServicioEnum> requestServicio = GeneralPayload.<ServicioEnum>builder()
                .requestHeader(header)
                .requestBody(servicio)
                .build();
        ResponseDto rtaService = servicioClient.findServiceByService(requestServicio).getBody();
        ServicioPayload servicioPayload = new Gson().fromJson(rtaService.getRespuestaServicio(), ServicioPayload.class);
        return Optional.of(servicioPayload.getId());
    }

    /**
     * Metodo con el cual se valida cuales servicios se debe almacenar una auditoria estricta
     * @param servicioEnum
     * @return
     */
    private Boolean validateEspecificCacheService(FlowOperationEnum servicioEnum) {
        if (FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_VIGIA_RESPONSE.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_DICTUM_RESPONSE.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_DICTUM_REQUEST.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_RECONOCER_REQUEST.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_RECONOCER_RESPONSE.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_UBICA_REQUEST.equals(servicioEnum) ||
                FlowOperationEnum.INVOKE_UBICA_RESPONSE.equals(servicioEnum)
        ) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private ServicioEnum validaServicio(FlowOperationEnum operationEnum) {
        if (FlowOperationEnum.VALIDATE_CITY.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_REQUEST.equals(operationEnum) || FlowOperationEnum.VALIDATE_CITY_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.VALIDATE_CITY;
        } else if (FlowOperationEnum.INVOKE_VIGIA.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_VIGIA_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.VIGIA;
        } else if (FlowOperationEnum.INVOKE_DICTUM.equals(operationEnum) || FlowOperationEnum.INVOKE_DICTUM_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_DICTUM_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.DICTUM;
        } else if (FlowOperationEnum.INVOKE_RECONOCER.equals(operationEnum) || FlowOperationEnum.INVOKE_RECONOCER_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_RECONOCER_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.RECONOCER;
        }else if (FlowOperationEnum.INVOKE_UBICA.equals(operationEnum) || FlowOperationEnum.INVOKE_UBICA_REQUEST.equals(operationEnum) || FlowOperationEnum.INVOKE_UBICA_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.RECONOCER;
        }else if (FlowOperationEnum.CASO_BIZAGI.equals(operationEnum) || FlowOperationEnum.CASO_BIZAGI_REQUEST.equals(operationEnum) || FlowOperationEnum.CASO_BIZAGI_RESPONSE.equals(operationEnum)) {
            return ServicioEnum.BIZAGI;
        }
        return ServicioEnum.NO_APLICA;
    }
}
