package co.com.santander.clients;

import co.com.santander.dto.dictum.RequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "dictum-service", url = "${dictum.url}")
public interface DictumClient {

    @RequestMapping(value = "/consultarHC2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String consultarHC2(@RequestBody GeneralPayload<RequestDictumDTO> request);
}
