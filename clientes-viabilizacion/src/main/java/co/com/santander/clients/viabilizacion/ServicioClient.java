package co.com.santander.clients.viabilizacion;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${viabilizacion.servicio.service-name}", url = "${viabilizacion.servicio.url}")
public interface ServicioClient {

    @RequestMapping(value = "/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseDto> findServiceByService(@RequestBody GeneralPayload<ServicioEnum> servicio);

}
