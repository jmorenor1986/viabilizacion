package co.com.santander.clients.viabilizacion;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${viabilizacion.principal-request.service-name}", url = "${viabilizacion.principal-request.url}")
public interface PrincipalRequestClient {


}
