package co.com.santander.core.errors;

import co.com.santander.adapters.primary.rest.solicitud.dto.ResponsePayLoad;
import co.com.santander.core.errors.dto.ConnectionErrorDto;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponsePayLoad> handleAllExceptions(Exception ex, WebRequest request) {
        String mensaje = ex.getMessage() + " " + ex.toString();
        if (ex instanceof ConnectionException) {
            ConnectionException exception = ((ConnectionException) ex);
            mensaje = new Gson().toJson(ConnectionErrorDto.builder()
                    .mensaje(ex.getMessage())
                    .method(exception.getMethod())
                    .params(exception.getParams())
                    .url(exception.getUrl())
                    .build());
        } else if (ex instanceof MandatoryFieldException) {
            MandatoryFieldException exception = (MandatoryFieldException) ex;
            mensaje = exception.getMessage();
        } else if (ex instanceof NumberException) {
            NumberException exception = (NumberException) ex;
            mensaje = exception.getMessage();
        } else if (ex instanceof BusinessException) {
            BusinessException exception = (BusinessException) ex;
            mensaje = exception.getMessage();
        }
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .codRespuesta(Long.valueOf("3"))
                .mensajeError(mensaje)
                .build()
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
