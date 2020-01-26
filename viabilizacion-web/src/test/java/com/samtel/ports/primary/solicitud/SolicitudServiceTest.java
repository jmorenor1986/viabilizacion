package com.samtel.ports.primary.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.services.solicitud.SolicitudServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolicitudServiceTest {

    private SolicitudService solicitudService;

    @Mock
    private Cliente cliente;

    @Before
    public void setUp() {
        solicitudService = new SolicitudServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSolicitudServiceSuccess(){
        String result = solicitudService.cumplimientoSolicitud(cliente);
        Assert.assertNotNull(result);
    }
}


