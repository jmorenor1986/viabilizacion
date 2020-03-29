package co.com.santander.persistencia.controller.logservice;


import co.com.santander.persistencia.controller.logservice.payload.LogPayload;
import co.com.santander.persistencia.controller.logservice.payload.LogServicePayload;
import co.com.santander.persistencia.controller.payload.GeneralPayload;
import co.com.santander.persistencia.service.LogService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Autowired
    public LogServiceController(LogService logService, ModelMapper modelMapper) {
        this.logService = logService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/logOperation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertLogOperation(@RequestBody GeneralPayload<LogPayload> payload) {
        return new ResponseEntity<>(logService.insertLogOperation(payload.getRequestBody()), HttpStatus.OK);
    }

    @PostMapping(value = "/logRest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertaLogRest(@RequestBody GeneralPayload<LogServicePayload> payload) {
        return new ResponseEntity<>(logService.insertaLogRest(payload.getRequestBody().getLog(), payload.getRequestBody().getIdCache()), HttpStatus.OK);
    }

}
