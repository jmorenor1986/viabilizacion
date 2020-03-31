package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.controller.payload.ServicioPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.service.ServicioService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> findServiceByService(@RequestBody GeneralPayload<ServicioEnum> servicio) {
        ServicioPayload servicioPayload = null;
        Optional<ServicioEntity>  servicioEntity = servicioService.findServiceByService(servicio.getRequestBody());
        if( servicioEntity.isPresent() ){
            servicioPayload = modelMapper.map(servicioEntity.get(), ServicioPayload.class);
        }
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .respuestaServicio( new Gson().toJson(servicioPayload) )
                .codRespuesta(1L)
                .build(), HttpStatus.OK);
    }

}
