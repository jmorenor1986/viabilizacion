package co.com.santander.service;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("prueba", "123");
        System.out.println("Llega al interceptor del request de los clientes");
    }
}
