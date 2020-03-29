package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.CacheUsrPayload;
import co.com.santander.persistencia.controller.payload.ValidateLogUserPayload;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.service.CacheUsrService;
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

    @Autowired
    public CacheUsrController(CacheUsrService cacheUsrService) {
        this.cacheUsrService = cacheUsrService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CacheUsrEntity> insertLogCacheUsr(@RequestBody CacheUsrPayload cacheUsrPayload) {
        return new ResponseEntity<>(cacheUsrService.insertLogCacheUsr(cacheUsrPayload.getLog(), cacheUsrPayload.getCache()), HttpStatus.OK);
    }

    @PostMapping(value = "/validarLog", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validateLogUser(@RequestBody ValidateLogUserPayload validityLogUserPayload) {
        return new ResponseEntity<>(cacheUsrService.validityLogUser(validityLogUserPayload.getCache(), validityLogUserPayload.getVig()).get(), HttpStatus.OK);
    }
}
