package co.com.santander.validation.controller;

import co.com.santander.validation.dto.GeneralPayload;
import co.com.santander.validation.dto.ResponsePayLoad;
import co.com.santander.validation.dto.TraerCiudad;
import co.com.santander.validation.dto.ValidarCiudad;
import co.com.santander.validation.entity.Ciudad;
import co.com.santander.validation.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("v1/ciudad")
public class CiudadController {
    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> validarCiudad(@RequestBody GeneralPayload<ValidarCiudad> ciudadPayload) {
        String respuestaServicio = ciudadService.validarCiudad(ciudadPayload.getRequestBody().getCiudad()).toString();
        return new ResponseEntity<>(ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("1"))
                        .mensajeError("OK")
                        .respuestaServicio(respuestaServicio)
                        .build()
                , HttpStatus.OK);
    }

    @PostMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> traerCiudades(@RequestBody GeneralPayload<TraerCiudad> ciudades){
    	List<Ciudad> cities = ciudadService.traerCiudades();
    	return new ResponseEntity<>(ResponsePayLoad.builder()
                .codRespuesta(Long.valueOf("1"))
                .respuestaServicio(cities)
                .mensajeError("OK")
                .build()
        , HttpStatus.OK);
    }
}
