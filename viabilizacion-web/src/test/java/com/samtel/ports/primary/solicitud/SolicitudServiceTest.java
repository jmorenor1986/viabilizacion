package com.samtel.ports.primary.solicitud;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ClienteValidator;
import com.samtel.errors.MandatoryFieldException;
import com.samtel.ports.primary.log.LogService;
import com.samtel.services.solicitud.SolicitudServiceImpl;
import com.samtel.utils.IGenerateUniqueId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class SolicitudServiceTest {

    private SolicitudService solicitudService;

    @Mock
    private Cliente cliente;

    private ClienteValidator clienteValidator;
    @Mock
    private LogService logService;

    @Mock
    private ValidateRequest validateRequest;
    @Mock
    private IGenerateUniqueId generateUniqueId;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clienteValidator = new ClienteValidator();
        solicitudService = new SolicitudServiceImpl(clienteValidator,logService,validateRequest, generateUniqueId );
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
        Optional<ResponseFlow> result = solicitudService.cumplimientoSolicitud(clienteLocal);
        Assert.assertNotNull(result);
    }

    @Test
    public void testCumplimientoSolicitudError() {
        expectedException.expect(MandatoryFieldException.class);
        expectedException.expectMessage("Request invalido");
        Optional<ResponseFlow> result = solicitudService.cumplimientoSolicitud(cliente);
        Assert.assertNotNull(result);

    }
}


