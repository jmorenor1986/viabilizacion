package co.com.santander.clients.viabilizacion;

import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.mail.MailPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${viabilizacion.email.service-name}", url = "${viabilizacion.email.url}")
public interface EmailSenderClient {

    @PostMapping(value = "${viabilizacion.email.metodo}", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    String sendMail(@RequestBody GeneralPayload<MailPayload> payload);
}