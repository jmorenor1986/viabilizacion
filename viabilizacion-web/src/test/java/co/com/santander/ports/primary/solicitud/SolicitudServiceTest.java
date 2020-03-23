package co.com.santander.ports.primary.solicitud;

import co.com.santander.adapters.secondary.database.santander.entity.PrincipalRequest;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.ClienteValidator;
import co.com.santander.core.domain.solicitud.RequestHeader;
import co.com.santander.core.errors.MandatoryFieldException;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.core.services.log.LogService;
import co.com.santander.core.services.log.PrincipalRequestService;
import co.com.santander.core.services.solicitud.SolicitudServiceImpl;
import co.com.santander.utils.IGenerateUniqueId;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    private PrincipalRequestService principalRequestService;
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
        solicitudService = new SolicitudServiceImpl(clienteValidator, logService, validateRequest, generateUniqueId, principalRequestService);
    }

    @Test
    public void testCumplimientoSolicitudSuccess() {
        RequestHeader requestHeader = new RequestHeader();
        Cliente clienteLocal = Cliente.builder().actividad("Actividad")
                .anoNacimiento("1991")
                .apellidos("apellidos")
                .celular("3229045674")
                .correoElectronico("correoElectronio")
                .direccion("direccion")
                .ingresos("1000000")
                .nombres("nombres")
                .numeroIdentificacion("10205689")
                .plazo("60")
                .telefono("8957631")
                .tipoIdentificacion("tipoIdentificacion")
                .valorSolicitado("800000")
                .canalOrigen("1")
                .requestHeader(requestHeader)
                .build();

        PrincipalRequest principalRequest = PrincipalRequest.builder()
                .codigoAliado(clienteLocal.getRequestHeader().getCodAliado())
                .usuarioAliado(clienteLocal.getRequestHeader().getUsuarioAliado())
                .ipOrigen(clienteLocal.getRequestHeader().getIpOrigen())
                .json(new Gson().toJson(clienteLocal.getRequestHeader()))
                .build();
        PrincipalRequest principalRequestResponse = PrincipalRequest.builder()
                .id(Long.valueOf("1"))
                .codigoAliado(clienteLocal.getRequestHeader().getCodAliado())
                .usuarioAliado(clienteLocal.getRequestHeader().getUsuarioAliado())
                .ipOrigen(clienteLocal.getRequestHeader().getIpOrigen())
                .json(new Gson().toJson(clienteLocal.getRequestHeader()))
                .build();
        Mockito.when(principalRequestService.insertaPrincipalRequest(Mockito.any())).thenReturn(principalRequestResponse);
        Optional<ResponseFlow> result = solicitudService.cumplimientoSolicitud(clienteLocal);
        Assert.assertNotNull(result);
    }

    @Test
    public void testCumplimientoSolicitudError() {
        expectedException.expect(MandatoryFieldException.class);
        expectedException.expectMessage("El campo  ACTIVIDAD_ECONOMICA es obligatorio");
        Optional<ResponseFlow> result = solicitudService.cumplimientoSolicitud(cliente);
        Assert.assertNotNull(result);
    }
}


