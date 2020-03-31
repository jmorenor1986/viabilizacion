package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.PrincipalRequestPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.PrincipalRequest;
import co.com.santander.persistencia.service.PrincipalRequestService;
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

@RestController
@RequestMapping("v1/principalrequest")
public class PrincipalRequestController {

    private final PrincipalRequestService principalRequestService;
    private final ModelMapper modelMapper;

    @Autowired
    public PrincipalRequestController(PrincipalRequestService principalRequestService, ModelMapper modelMapper) {
        this.principalRequestService = principalRequestService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> insertaPrincipalRequest(@RequestBody GeneralPayload<PrincipalRequestPayload> payload) {
        PrincipalRequest principalRequest = modelMapper.map(payload.getRequestBody(), PrincipalRequest.class);
        principalRequest.setJson(new Gson().toJson(payload.getRequestHeader()));
        return new ResponseEntity<>(ResponsePayLoad.builder()
                .codRespuesta(1L)
                .respuestaServicio(new Gson().toJson(principalRequestService.insertaPrincipalRequest(principalRequest)))
                .build(), HttpStatus.OK);
    }
}
