package co.com.santander.adapters.primary.rest.solicitud;

import co.com.santander.adapters.primary.rest.solicitud.dto.ClientePayLoad;
import co.com.santander.adapters.primary.rest.solicitud.dto.ResponsePayLoad;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.ports.primary.solicitud.MapperCliente;
import co.com.santander.ports.primary.solicitud.SolicitudService;
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
@RequestMapping("/v1/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final ModelMapper modelMapper;
    private MapperCliente mapperCliente;

    @Autowired
    public SolicitudController(SolicitudService solicitudService, ModelMapper modelMapper, MapperCliente mapperCliente) {
        this.solicitudService = solicitudService;
        this.modelMapper = modelMapper;
        this.mapperCliente = mapperCliente;
    }

    @PostMapping(value = "/viabilizacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePayLoad> solicitud(@RequestBody GeneralPayload<ClientePayLoad> clientePayLoad) {
        Optional<ResponseFlow> result = solicitudService.cumplimientoSolicitud(mapperCliente.fromGeneralPayLoad(clientePayLoad));
        String respuestaServicio = (result.isPresent() ? result.get().toString() : ResponseFlow.UNEXPECTED_ERROR.toString());
        return new ResponseEntity<>(
                ResponsePayLoad.builder()
                        .codRespuesta(Long.valueOf("1"))
                        .respuestaServicio(respuestaServicio)
                        .mensajeError("OK")
                        .build()
                , HttpStatus.OK);
    }
}
