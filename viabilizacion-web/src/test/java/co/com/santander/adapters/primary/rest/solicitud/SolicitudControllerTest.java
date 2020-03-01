package co.com.santander.adapters.primary.rest.solicitud;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.ports.primary.solicitud.SolicitudService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class SolicitudControllerTest {
    public static final String EXPECTED_RESULT = "RESULT";
    private SolicitudController solicitudController;

    @Mock
    private SolicitudService solicitudService;
    @Mock
    private ClientePayLoad clientePayLoad;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Cliente cliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        solicitudController = new SolicitudController(solicitudService, modelMapper);
    }

    @Test
    public void testCumplimientoSolicitudSuccess() {
        Mockito.when(modelMapper.map(clientePayLoad, Cliente.class)).thenReturn(cliente);
        Mockito.when(solicitudService.cumplimientoSolicitud(cliente)).thenReturn(Optional.empty());
        ResponseFlow result = solicitudController.solicitud(clientePayLoad).orElse(ResponseFlow.UNEXPECTED_ERROR);
        Assert.assertEquals(ResponseFlow.UNEXPECTED_ERROR, result);
    }

}
