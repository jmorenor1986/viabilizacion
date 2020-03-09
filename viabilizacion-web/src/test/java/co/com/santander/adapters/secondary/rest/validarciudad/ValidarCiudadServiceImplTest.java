
package co.com.santander.adapters.secondary.rest.validarciudad;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.validarciudad.dto.ValidarCiudad;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class ValidarCiudadServiceImplTest {

    public static final String URI = "http://localhost:5001/validacion/v1/ciudad";
    public static final String NOMBRE_CIUDAD = "BOGOTA";
    private ValidarCiudadService validarCiudadService;
    private ClientesProperties properties;
    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private JsonUtilities jsonUtilities;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        properties = new ClientesProperties();
        properties.setUriValidarCiudad(URI);
        validarCiudadService = new ValidarCiudadServiceImpl(restTemplateService, properties, jsonUtilities);
    }

    @Test
    public void testValidarCiudadReturnTrue() {
        Map<String, String> headers = new HashMap<>();
        headers.put("idRequest", "123");
        GeneralPayload<ValidarCiudad> validaCiudad = GeneralPayload.<ValidarCiudad>builder()
                .requestHeader(new RequestHeader())
                .requestBody(ValidarCiudad.builder()
                        .ciudad(NOMBRE_CIUDAD)
                        .build())
                .build();

        Mockito.when(restTemplateService.getWithPathParams(properties.getUriValidarCiudad(), new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), Optional.of(headers))).thenReturn(Optional.of("true"));
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

        Mockito.when(restTemplateService.getWithPathParams(properties.getUriValidarCiudad(), new ArrayList<>(Arrays.asList(NOMBRE_CIUDAD)), Optional.of(headers))).thenReturn(Optional.of("false"));
        String result = validarCiudadService.validarCodigoCiudad(validaCiudad, Long.valueOf("123"));
        Assert.assertEquals("false", result);
    }

}
