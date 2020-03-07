package co.com.santander.adapters.primary.rest.solicitud;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.primary.rest.solicitud.dto.ClientePayLoad;
import co.com.santander.adapters.primary.rest.solicitud.dto.ResponsePayLoad;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.primary.solicitud.MapperCliente;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@SpringBootTest
public class SolicitudControllerTest {
    public static final String EXPECTED_RESULT = "RESULT";
    private SolicitudController solicitudController;

    @Mock
    private SolicitudService solicitudService;
    @Mock
    private GeneralPayload<ClientePayLoad> clientePayLoad;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Cliente cliente;
    @Mock
    private MapperCliente mapperCliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        solicitudController = new SolicitudController(solicitudService, modelMapper, mapperCliente);
    }

    @Test
    public void testCumplimientoSolicitudSuccess() {
        Cliente cliente = Cliente.builder()
                .nombres("Jesus Nicolas")
                .build();
        Mockito.when(mapperCliente.fromGeneralPayLoad(clientePayLoad)).thenReturn(cliente);
        Mockito.when(solicitudService.cumplimientoSolicitud(cliente)).thenReturn(Optional.of(ResponseFlow.UNEXPECTED_ERROR));


        Mockito.when(solicitudService.cumplimientoSolicitud(cliente)).thenReturn(Optional.of(ResponseFlow.UNEXPECTED_ERROR));
        ResponseEntity<GeneralPayload<ResponsePayLoad>> result = solicitudController.solicitud(clientePayLoad);
        Assert.assertEquals(ResponseFlow.UNEXPECTED_ERROR.toString(), result.getBody().getRequestBody().getRespuestaServicio());
    }

}
