package com.samtel.ports.primary.solicitud;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.errors.MandatoryFieldException;
import com.samtel.ports.primary.log.LogService;
import com.samtel.services.solicitud.SolicitudServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    private ClienteValidator clienteValidator;
    @Mock
    private LogService logService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        clienteValidator = new ClienteValidator();
        solicitudService = new SolicitudServiceImpl(clienteValidator,logService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCumplimientoSolicitudSuccess() {
        Cliente clienteLocal = Cliente.builder().actividad("Actividad")
                .anoNacimiento("anoNacimiento")
                .apellidos("apellidos")
                .celular("celular")
                .correoElectronico("correoElectronio")
                .direccion("direccion")
                .ingresos("ingresos")
                .nombres("nombres")
                .numeroIdentificacion("numer0")
                .plazo("plazo")
                .telefono("telefono")
                .tipoIdentificacion("tipoIdentificacion")
                .valorSolicitado("valorsolicitado")
                .build();
        Optional<String> result = solicitudService.cumplimientoSolicitud(clienteLocal);
        Assert.assertEquals("Validation Ok", result.get());
    }

    @Test
    public void testCumplimientoSolicitudError() {
        expectedException.expect(MandatoryFieldException.class);
        expectedException.expectMessage("Request invalido");
        Optional<String> result = solicitudService.cumplimientoSolicitud(cliente);
        Assert.assertNotNull(result);

    }
}


