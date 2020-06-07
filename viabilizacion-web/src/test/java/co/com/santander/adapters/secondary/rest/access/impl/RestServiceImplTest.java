package co.com.santander.adapters.secondary.rest.access.impl;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.clients.*;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceImplTest {

    public static final String RESPUESTA_STRING = "1212112";
    private RestService restService;
    @Mock
    private ValidateCityClient validateCityClient;
    @Mock
    private VigiaClient vigiaClient;
    @Mock
    private DictumClient dictumClient;
    @Mock
    private ReconocerClient reconocerClient;
    @Mock
    private UbicaClient ubicaClient;
    @Mock
    private BizagiClient bizagiClient;
    @Mock
    private JsonUtilities jsonUtilities;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        restService = new RestServiceImpl(jsonUtilities, validateCityClient, vigiaClient, dictumClient, reconocerClient, ubicaClient, bizagiClient);
        Mockito.when(validateCityClient.consultaCity(Mockito.any())).thenReturn(ResponseDto.builder().build());
        Mockito.when(jsonUtilities.getGeneralResponse(Mockito.any())).thenReturn(ResponseDto.builder().build());
        Mockito.when(bizagiClient.consultarHC2(Mockito.any())).thenReturn(ResponseDto.builder().build());
        Mockito.when(vigiaClient.consultaVigia(Mockito.any())).thenReturn(RESPUESTA_STRING);
        Mockito.when(dictumClient.consultarHC2(Mockito.any())).thenReturn(RESPUESTA_STRING);
        Mockito.when(reconocerClient.obtenerToken(Mockito.any())).thenReturn(RESPUESTA_STRING);
        Mockito.when(reconocerClient.firmaElectronica(Mockito.any())).thenReturn(RESPUESTA_STRING);
        Mockito.when(ubicaClient.ubicaPostService(Mockito.any())).thenReturn(RESPUESTA_STRING);
    }


    @Test
    public void testCallServiceVALIDATE_CITY() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.VALIDATE_CITY, null));
    }

    @Test
    public void testCallServiceVIGIA() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.VIGIA, null));
    }

    @Test
    public void testCallServiceDICTUM() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.DICTUM, null));
    }

    @Test
    public void testCallServiceTOKEN_RECONOCER() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.TOKEN_RECONOCER, null));
    }

    @Test
    public void testCallServiceUBICA() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.UBICA, null));
    }

    @Test
    public void testCallServiceRECONOCER() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.RECONOCER, null));
    }

    @Test
    public void testCallServiceBIZAGI() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.BIZAGI, null));
    }

    @Test
    public void testCallServiceOTHER() {
        Assert.assertNotNull(restService.callService(GeneralPayload.builder().build(), ServicioEnum.NO_APLICA, null));
    }
}