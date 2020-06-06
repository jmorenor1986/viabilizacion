package co.com.santander.clients.viabilizacion;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.CacheLogPayload;
import co.com.santander.dto.viabilizacion.ValidateLogUserPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${viabilizacion.cache.service-name}", url = "${viabilizacion.cache.url}")
public interface CacheUsrClient {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> insertLogCacheUsr(@RequestBody GeneralPayload<CacheLogPayload> cacheUsrPayload);

    @RequestMapping(value = "/validarLog",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> validateLogUser(@RequestBody GeneralPayload<ValidateLogUserPayload> validityLogUserPayload);
}
