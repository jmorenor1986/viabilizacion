package com.samtel.adapters.primary.rest.solicitud;

import com.samtel.ports.primary.solicitud.SolicitudService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolicitudControllerTest {
    private SolicitudController solicitudController;

    @Mock
    private SolicitudService solicitudService;

    @Mock
    private ClientePayLoad clientePayLoad;

    @Before
    public void setup(){
        solicitudController = new SolicitudController(solicitudService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCumplimientoSolicitudSuccess(){
        String result = solicitudController.solicitud(clientePayLoad);
    }
}
