package co.com.santander.clients.viabilizacion;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.LogServicePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${viabilizacion.log.service-name}", url = "${viabilizacion.log.url}")
public interface LogClient {

    @PostMapping(value = "/logOperation", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> insertLogOperation(@RequestBody GeneralPayload<LogPayload> payload);

    @RequestMapping(value = "/logRest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> insertaLogRest(@RequestBody GeneralPayload<LogServicePayload> payload);

}
