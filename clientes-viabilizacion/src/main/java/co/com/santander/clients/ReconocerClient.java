package co.com.santander.clients;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "reconocer-service", url = "${reconocer.url}")
public interface ReconocerClient {

    @RequestMapping(value = "/obtenerToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto obtenerToken(@RequestBody GeneralPayload<String> request);

    @RequestMapping(value = "/consultaReconocer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto firmaElectronica(@RequestBody GeneralPayload<String> request);
}
