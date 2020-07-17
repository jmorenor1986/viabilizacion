package co.com.santander.clients;

import co.com.santander.dto.generic.GeneralPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${reconocer.service-name}", url = "${reconocer.url}")
public interface ReconocerClient {

    @RequestMapping(value = "${reconocer.metodo.consulta-token}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String obtenerToken(@RequestBody GeneralPayload<String> request);

    @RequestMapping(value = "${reconocer.metodo.consulta-reconocer}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String firmaElectronica(@RequestBody GeneralPayload<String> request);

}
