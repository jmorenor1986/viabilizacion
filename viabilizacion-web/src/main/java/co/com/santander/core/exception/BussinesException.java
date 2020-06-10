package co.com.santander.core.exception;

import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class BussinesException extends RuntimeException {
    @Getter
    private ServicioEnum servicioEnum;
    @Getter
    private String respuesta;

    public BussinesException(String message, ServicioEnum servicioEnum, String respuesta) {
        super(message);
        this.servicioEnum = servicioEnum;
        this.respuesta = respuesta;
    }
}
