package co.com.santander.adapters.secondary.rest.access.proxy;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.mapper.FilterLogMapper;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.constants.FlowOperationEnum;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.primary.FindUrlService;
import co.com.santander.ports.secondary.accesodatos.LogService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("proxyRestServiceImpl")
public class ProxyRestTemplateServiceImpl implements RestService {

    private RestService restService;
    private LogService logService;
    private FilterLogMapper filterLogMapper;
    private final FindUrlService findUrlService;

    @Getter @Setter
    private Long idRequest;
    @Getter @Setter
    private String idCache;
    @Getter @Setter
    private Optional<Map<String, String>> headers;
    @Getter @Setter
    private String body;
    @Getter @Setter
    private FlowOperationEnum operation;


    @Autowired
    public ProxyRestTemplateServiceImpl(@Qualifier("restServiceImpl") RestService restService
            , LogService logService
            , FilterLogMapper filterLogMapper
            , FindUrlService findUrlService) {
        this.restService = restService;
        this.logService = logService;
        this.filterLogMapper = filterLogMapper;
        this.findUrlService = findUrlService;
    }


    private void generateLog(Object body, RequestHeader header, Optional<Map<String, String>> headers, ServicioEnum servicio ){
        setHeaders(headers);
        setBody(new Gson().toJson(body));
        findHeadersLog();
        logRequest(servicio, header);
    }

    private String findUrlService(ServicioEnum servicio){
        Optional<String> url = findUrlService.getUrlFrom(servicio);
        if(url.isPresent()){
            return url.get();
        }else{
            return "NO_EXISTE_INFORMACION";
        }
    }

    private void logResponse(String body, ServicioEnum servicio) {
        LogPayload logEntity = filterLogMapper.toLogResponse(servicio, body, getIdRequest());
        logEntity.setUrl(findUrlService(servicio));
        GeneralPayload< LogPayload > requestLog = GeneralPayload.<LogPayload>builder()
                .requestBody(logEntity)
                .build();
        logService.insertaLogRest(requestLog, getIdCache());
    }

    private void logRequest(ServicioEnum servicio, RequestHeader header ){
    	LogPayload logEntity = filterLogMapper.toLogRequest(servicio, getBody() , getIdRequest());
    	logEntity.setUrl(findUrlService(servicio));
    	GeneralPayload< LogPayload > requestLog = GeneralPayload.<LogPayload>builder()
                .requestBody(logEntity)
                .requestHeader(header)
                .build();
        setOperation( logEntity.getTipo() );
        logService.insertaLogRest(requestLog, getIdCache());
    }

    private void findHeadersLog(){
        if(getHeaders().isPresent()){
            if(getHeaders().get().get("idRequest") != null ){
                setIdRequest(Long.valueOf(getHeaders().get().get("idRequest")));
            }
            if(getHeaders().get().get("idCache") != null ){
                setIdCache(getHeaders().get().get("idCache"));
            }
        }
    }

    @Override
    public Optional<ResponseDto> callService(GeneralPayload request, ServicioEnum servicio, Optional<Map<String, String>> cache) {
        generateLog(request,request.getRequestHeader(), cache, servicio);
        Optional<ResponseDto> rta = restService.callService(request, servicio, cache);
        logResponse(new Gson().toJson(rta.get()), servicio);
        return rta.isPresent() ? rta : Optional.empty();
    }
}
