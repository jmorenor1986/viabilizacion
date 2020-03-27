package co.com.santander.clients;

import co.com.santander.dto.vigia.VigiaDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "vigia-service", url = "${vigia.url}")
public interface VigiaClient {

    @RequestMapping(value = "/consultaVigia", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto consultaVigia(@RequestBody GeneralPayload<VigiaDTO> request);
}
