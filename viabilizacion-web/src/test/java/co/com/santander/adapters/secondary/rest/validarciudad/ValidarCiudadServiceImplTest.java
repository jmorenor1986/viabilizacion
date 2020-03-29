
package co.com.santander.adapters.secondary.rest.validarciudad;


import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.constants.ServicioEnum;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class ValidarCiudadServiceImplTest {

    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";
    public static final String NOMBRE_CIUDAD = "BOGOTA";
    private ValidarCiudadService validarCiudadService;
    private ClientesProperties properties;
    @Mock
    private RestService restService;
    @Mock
    private JsonUtilities jsonUtilities;

    private Optional<Map<String, String>> genericHeaders;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriValidarCiudad(URI);
        validarCiudadService = new ValidarCiudadServiceImpl(restService, properties, jsonUtilities);
        //Generamos Cabeceras
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", "123");
        genericHeaders = Optional.of(headers);
    }

    @Test
    public void testValidarCiudadReturnTrue() {
        GeneralPayload<ValidarCiudad> validaCiudad = GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(new RequestHeader())
                .requestBody(ValidarCiudad.builder()
                        .ciudad(NOMBRE_CIUDAD)
                        .build())
                .build();
        Mockito.when(restService.callService(validaCiudad, ServicioEnum.VALIDATE_CITY, genericHeaders ) ).thenReturn(Optional.of(ResponseDto.builder().codRespuesta("1").respuestaServicio("true").build()));
        String result = validarCiudadService.validarCodigoCiudad(validaCiudad, Long.valueOf("123"));
        Assert.assertEquals("false", result);
    }

    @Test
    public void testValidarCiudadReturnFalse() {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", "123");
        GeneralPayload<ValidarCiudad> validaCiudad = GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(new RequestHeader())
                .requestBody(ValidarCiudad.builder()
                        .ciudad(NOMBRE_CIUDAD)
                        .build())
                .build();

        Mockito.when(restService.callService(validaCiudad, ServicioEnum.VALIDATE_CITY, genericHeaders ) ).thenReturn(Optional.of(ResponseDto.builder().codRespuesta("1").respuestaServicio("false").build()));
        String result = validarCiudadService.validarCodigoCiudad(validaCiudad, Long.valueOf("123"));
        Assert.assertEquals("false", result);
    }

}
