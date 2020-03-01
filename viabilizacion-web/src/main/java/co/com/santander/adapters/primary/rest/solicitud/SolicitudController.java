package co.com.santander.adapters.primary.rest.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import co.com.santander.core.response.ResponseFlow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    
    @Autowired
    public SolicitudController(SolicitudService solicitudService, ModelMapper modelMapper) {
        this.solicitudService = solicitudService;
        this.modelMapper = modelMapper;
    }
    
    @PostMapping(value = "/viabilizacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ResponseFlow> solicitud(@RequestBody ClientePayLoad clientePayLoad) {
        return solicitudService.cumplimientoSolicitud(modelMapper.map(clientePayLoad, Cliente.class));
    }
}
