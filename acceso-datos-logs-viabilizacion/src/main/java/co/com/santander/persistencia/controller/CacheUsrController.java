package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.CacheLogPayload;
import co.com.santander.persistencia.controller.payload.ValidateLogUserPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.service.CacheUsrService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1/cache")
public class CacheUsrController {

    private final CacheUsrService cacheUsrService;
    private final ModelMapper modelMapper;

    @Autowired
    public CacheUsrController(CacheUsrService cacheUsrService, ModelMapper modelMapper) {
        this.cacheUsrService = cacheUsrService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> insertLogCacheUsr(@RequestBody GeneralPayload<CacheLogPayload> cacheUsrPayload) {
        LogEntity logEntity = modelMapper.map(cacheUsrPayload, LogEntity.class);
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .codRespuesta(1L)
                .respuestaServicio(new Gson().toJson(cacheUsrService.insertLogCacheUsr(logEntity, cacheUsrPayload.getRequestBody().getCache())))
                .build(), HttpStatus.OK);
    }

    @PostMapping(value = "/validarLog", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> validateLogUser(@RequestBody GeneralPayload<ValidateLogUserPayload> validityLogUserPayload) {
        String rtaString = "";
        Long codigo = Long.valueOf("2");
        String mensaje = "";
        Optional< String > rta =  cacheUsrService.validityLogUser(validityLogUserPayload.getRequestBody().getCache(), validityLogUserPayload.getRequestBody().getVig(), validityLogUserPayload.getRequestBody().getServicio());
        if(rta.isPresent()){
            rtaString = rta.get();
            codigo = Long.valueOf("1");
        }else{
            mensaje = "NO EXISTE INFORMACION";
        }

        return new ResponseEntity<>(ResponsePayLoad.builder()
                .codRespuesta(codigo)
                .respuestaServicio(rtaString)
                .mensajeError(mensaje)
                .build(), HttpStatus.OK);
    }
}
