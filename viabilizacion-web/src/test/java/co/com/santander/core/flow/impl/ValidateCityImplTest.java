package co.com.santander.core.flow.impl;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.flow.ValidateRequest;
import co.com.santander.core.response.ResponseFlow;
import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import co.com.santander.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidateCityImplTest {

    public static final String NOMBRE_CIUDAD = "BOGOTA";

    private ValidateRequest validateRequest;
    private GenerateUniqueIdImpl generateUniqueId;
    
    @Mock
    private ValidarCiudadService validarCiudadService;
    @Mock
    private ValidateRequest next;
    @Mock
    private Cliente cliente;

    private ModelMapper mapper;
    
    private String requestId;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mapper = new ModelMapper();
        validateRequest = new ValidateCityImpl(next, validarCiudadService, mapper);
        generateUniqueId = new GenerateUniqueIdImpl();
    }

    @Test
    public void testValidateCityImplSuccess() {
        Long requestId = Long.valueOf("1");
        Cliente cliente = Cliente.builder()
                .requestHeader(new RequestHeader())
                .tipoIdentificacion("CC")
                .numeroIdentificacion("1015")
                .nombres("Pepito")
                .apellidos("Perez")
                .direccion("cra 34 calle 26 - 75 sur")
                .telefono("2365417")
                .ciudad(NOMBRE_CIUDAD)
                .build();
        GeneralPayload<ValidarCiudad> envio = GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(new RequestHeader())
                .requestBody(ValidarCiudad.builder()
                        .ciudad(NOMBRE_CIUDAD)
                        .build())
                .build();
        Mockito.when(validarCiudadService.validarCodigoCiudad(envio,requestId)).thenReturn("true");
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.NEGADO);
        Assert.assertNotNull( result );
    }

    @Test
    public void testValidateCityImplError() {
        Long requestId = Long.valueOf("1");
        Cliente cliente = Cliente.builder()
                .requestHeader(new RequestHeader())
                .tipoIdentificacion("CC")
                .numeroIdentificacion("1015")
                .nombres("Pepito")
                .apellidos("Perez")
                .direccion("cra 34 calle 26 - 75 sur")
                .telefono("2365417")
                .ciudad(NOMBRE_CIUDAD)
                .build();
        GeneralPayload<ValidarCiudad> envio = GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(new RequestHeader())
                .requestBody(ValidarCiudad.builder()
                        .ciudad(NOMBRE_CIUDAD)
                        .build())
                .build();
        Mockito.when(validarCiudadService.validarCodigoCiudad(envio,requestId)).thenReturn("false");
        ResponseFlow result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.NEGADO);
        Assert.assertNotNull( result );
    }
}
