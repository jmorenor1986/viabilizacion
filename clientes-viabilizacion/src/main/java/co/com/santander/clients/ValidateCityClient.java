package co.com.santander.clients;

import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "validar-ciudad-service", url = "${validarciudad.url}")
public interface ValidateCityClient {

    @RequestMapping(value = "${validarciudad.metodo.consultar-ciudad}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto consultaCity(@RequestBody GeneralPayload<ValidarCiudad> request);
}
