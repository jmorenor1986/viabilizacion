package co.com.santander.utils.exception;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.primary.rest.solicitud.dto.ResponsePayLoad;
import co.com.santander.core.errors.ConnectionException;
import co.com.santander.utils.exception.dto.ConnectionErrorDto;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<GeneralPayload<ResponsePayLoad>> handleAllExceptions(Exception ex, WebRequest request) {
        String mensaje = ex.getMessage() + " " + ex.toString();
        System.out.println(
                "**************************Mensaje Controlado por aspecto (ExceptionHandler)*******************************************");
        ex.printStackTrace();
        System.out.println("*********************************************************************");
        if(ex instanceof ConnectionException){
            ConnectionException exception = ((ConnectionException) ex);
            mensaje = new Gson().toJson( ConnectionErrorDto.builder()
                    .mensaje( ex.getMessage() )
                    .method(exception.getMethod())
                    .params(exception.getParams())
                    .url(exception.getUrl())
                    .build() );
        }
        return new ResponseEntity<>(GeneralPayload.<ResponsePayLoad>builder()
                .requestBody(ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("3"))
                        .mensajeError( mensaje )
                        .build())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
