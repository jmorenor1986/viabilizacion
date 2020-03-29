package co.com.santander.persistencia.controller.cacheusr;

import co.com.santander.persistencia.controller.cacheusr.payload.LogPayload;
import co.com.santander.persistencia.controller.cacheusr.payload.ValidateLogUserPayload;
import co.com.santander.persistencia.controller.payload.GeneralPayload;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.service.CacheUsrService;
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
    public ResponseEntity<CacheUsrEntity> insertLogCacheUsr(@RequestBody GeneralPayload<LogPayload> cacheUsrPayload) {
        LogEntity logEntity = modelMapper.map(cacheUsrPayload, LogEntity.class);
        return new ResponseEntity<>(cacheUsrService.insertLogCacheUsr(logEntity, cacheUsrPayload.getRequestBody().getCache()), HttpStatus.OK);
    }

    @PostMapping(value = "/validarLog", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validateLogUser(@RequestBody GeneralPayload<ValidateLogUserPayload> validityLogUserPayload) {
        return new ResponseEntity<>(cacheUsrService.validityLogUser(validityLogUserPayload.getRequestBody().getCache(), validityLogUserPayload.getRequestBody().getVig()).get(), HttpStatus.OK);
    }
}
