package co.com.santander.clients;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.vigia.VigiaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${vigia.service-name}", url = "${vigia.url}")
public interface VigiaClient {

    @RequestMapping(value = "${vigia.metodo.consultar-vigia}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String consultaVigia(@RequestBody GeneralPayload<VigiaDTO> request);

}
