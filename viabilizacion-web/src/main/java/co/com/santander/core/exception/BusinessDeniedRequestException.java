package co.com.santander.core.exception;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class BusinessDeniedRequestException extends RuntimeException {

    @Getter
    private ServicioEnum servicioEnum;
    @Getter
    private String respuesta;
    @Getter
    private Cliente cliente;
    @Getter
    private Long idRequest;

    public BusinessDeniedRequestException(ServicioEnum servicioEnum, String respuesta, Cliente cliente, Long idRequest) {
        this.servicioEnum = servicioEnum;
        this.respuesta = respuesta;
        this.cliente = cliente;
        this.idRequest = idRequest;
    }
}
