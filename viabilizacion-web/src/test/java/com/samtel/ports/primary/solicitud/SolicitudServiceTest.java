package com.samtel.ports.primary.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
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

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolicitudServiceTest {

    private SolicitudService solicitudService;

    @Mock
    private Cliente cliente;
    @Mock
    private ClienteValidator clienteValidator;

    @Before
    public void setUp() {
        solicitudService = new SolicitudServiceImpl(clienteValidator);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCumplimientoSolicitudEmpty() {
        Mockito.when(clienteValidator.validateMandatory(Mockito.any())).thenReturn(true);
        Optional<String> result = solicitudService.cumplimientoSolicitud(cliente);
        Assert.assertEquals(Optional.empty(), result);
    }
}


