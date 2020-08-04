package co.com.santander.core.errors;

import co.com.santander.adapters.primary.rest.solicitud.dto.ResponsePayLoad;
import co.com.santander.adapters.primary.rest.solicitud.dto.SolicitudPayLoad;
import co.com.santander.core.errors.dto.ConnectionErrorDto;
import co.com.santander.core.exception.BusinessDeniedRequestException;
import co.com.santander.core.exception.BussinesException;
import co.com.santander.ports.secondary.solicitud.EnvioCorreoService;
import com.google.gson.Gson;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EnvioCorreoService envioCorreoService;


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

    @ExceptionHandler(BussinesException.class)
    public final ResponseEntity<Object> handlerInvalidNumVerificadorException(BussinesException ex, WebRequest request) {
        return new ResponseEntity<>(
                ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("0"))
                        .respuestaServicio(SolicitudPayLoad.builder().solicitud(ex.getRespuesta()).build())
                        .mensajeError("OK")
                        .build()
                , HttpStatus.OK);
    }

    @ExceptionHandler(FeignException.class)
    public final ResponseEntity<Object> handlerFeignException(FeignException ex, WebRequest request) {
        return new ResponseEntity<>(
                ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("3"))
                        .respuestaServicio(SolicitudPayLoad.builder()
                                .solicitud("Error de conexion: Url: " + ex.request().url() + " Estado: " + ex.status())
                                .build())
                        .mensajeError("Error")
                        .build()
                , HttpStatus.OK);
    }

    @ExceptionHandler(BusinessDeniedRequestException.class)
    public final ResponseEntity<Object> handlerBusinessDeniedRequestException(BusinessDeniedRequestException ex, WebRequest request) {
        envioCorreoService.envioCorreo(ex.getCliente(), ex.getIdRequest());
        return new ResponseEntity<>(
                ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("0"))
                        .respuestaServicio(SolicitudPayLoad.builder().solicitud(ex.getRespuesta()).build())
                        .mensajeError("OK")
                        .build()
                , HttpStatus.OK);

    }
}
