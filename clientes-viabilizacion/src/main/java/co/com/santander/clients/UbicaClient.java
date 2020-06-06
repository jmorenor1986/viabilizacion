package co.com.santander.clients;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.ubica.RequestUbicaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${ubica.service-name}", url = "${ubica.url}")
public interface UbicaClient {

    @RequestMapping(value = "/ubicaService", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String ubicaPostService(@RequestBody GeneralPayload<RequestUbicaDTO> request);
}
