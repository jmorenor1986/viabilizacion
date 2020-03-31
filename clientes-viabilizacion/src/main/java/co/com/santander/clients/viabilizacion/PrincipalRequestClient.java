package co.com.santander.clients.viabilizacion;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.PrincipalRequestPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${viabilizacion.principal-request.service-name}", url = "${viabilizacion.principal-request.url}")
public interface PrincipalRequestClient {

    @RequestMapping(value = "/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> insertaPrincipalRequest(@RequestBody GeneralPayload<PrincipalRequestPayload> payload);
}
