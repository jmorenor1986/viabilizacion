package co.com.santander.clients;

import co.com.santander.dto.dictum.RequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${bizagi.service-name}", url = "${bizagi.url}")
public interface BizagiClient {

    @RequestMapping(value = "${bizagi.metodo.create-case}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto consultarHC2(@RequestBody GeneralPayload<RequestDictumDTO> request);

}
