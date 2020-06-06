package co.com.santander.persistencia.controller;


import co.com.santander.persistencia.controller.payload.LogPayload;
import co.com.santander.persistencia.controller.payload.LogServicePayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.service.LogService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/logs")
public class LogServiceController {

    private final LogService logService;

    @Autowired
    public LogServiceController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping(value = "/logOperation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> insertLogOperation(@RequestBody GeneralPayload<LogPayload> payload) {
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .respuestaServicio(new Gson().toJson( logService.insertLogOperation(payload.getRequestBody())))
                .codRespuesta(1L)
                .build(), HttpStatus.OK);
    }

    @PostMapping(value = "/logRest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> insertaLogRest(@RequestBody GeneralPayload<LogServicePayload> payload) {
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .respuestaServicio(new Gson().toJson(logService.insertaLogRest(payload.getRequestBody().getLog(), payload.getRequestBody().getIdCache())))
                .codRespuesta(1L)
                .build(), HttpStatus.OK);
    }

}
