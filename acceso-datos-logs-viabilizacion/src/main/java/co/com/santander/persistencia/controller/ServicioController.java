package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.service.ServicioService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/servicio")
public class ServicioController {
    private final ServicioService servicioService;
    private final ModelMapper modelMapper;

    @Autowired
    public ServicioController(ServicioService servicioService, ModelMapper modelMapper) {
        this.servicioService = servicioService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> findServiceByService(@RequestBody ServicioEnum servicio) {
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .respuestaServicio(new Gson().toJson(servicioService.findServiceByService(servicio).get()))
                .codRespuesta(1L)
                .build(), HttpStatus.OK);
    }

}
