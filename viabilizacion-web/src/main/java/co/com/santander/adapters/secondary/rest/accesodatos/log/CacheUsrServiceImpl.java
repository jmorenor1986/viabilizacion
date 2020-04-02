package co.com.santander.adapters.secondary.rest.accesodatos.log;

import co.com.santander.clients.viabilizacion.CacheUsrClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.CachePayload;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.ValidateLogUserPayload;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CacheUsrServiceImpl implements CacheUsrService {

    private final CacheUsrClient cacheClient;

    @Autowired
    public CacheUsrServiceImpl(CacheUsrClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    @Override
    public CachePayload insertLogCacheUsr(LogPayload log, String cache) {
        return null;
    }

    @Override
    public Optional<String> validityLogUser(String cache, Long vig, FlowOperationEnum servicio) {
        GeneralPayload<ValidateLogUserPayload> request = GeneralPayload.<ValidateLogUserPayload>builder()
                .requestBody(ValidateLogUserPayload.builder()
                        .cache(cache)
                        .vig(vig)
                        .servicio(servicio)
                        .build())
                .build();
        ResponseDto responseDto = cacheClient.validateLogUser(request).getBody();
        if( "1".equalsIgnoreCase(responseDto.getCodRespuesta()) ){
            return Optional.of(responseDto.getRespuestaServicio());
        }
        return Optional.empty();
    }

    private Boolean isValidLogDate(Date logDate, Long vig){
        Long diffTime = new Date().getTime() - logDate.getTime();
        Long diffDays = diffTime / (1000 * 60 * 60 * 24);
        if(diffDays < vig){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private String evaluoTipo(FlowOperationEnum operation) {
        if (operation.toString().contains("REQUEST")) {
            return "REQUEST";
        } else if (operation.toString().contains("RESPONSE")) {
            return "RESPONSE";
        } else {
            return "NA";
        }
    }
}