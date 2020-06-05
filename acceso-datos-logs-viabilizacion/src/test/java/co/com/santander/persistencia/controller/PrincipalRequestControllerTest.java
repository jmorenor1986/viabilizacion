package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.PrincipalRequestPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.RequestHeader;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.PrincipalRequest;
import co.com.santander.persistencia.service.PrincipalRequestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class PrincipalRequestControllerTest {

    @Mock
    private PrincipalRequestService principalRequestService;
    private ModelMapper modelMapper;
    private PrincipalRequestController principalRequestController;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
        principalRequestController = new PrincipalRequestController(principalRequestService, modelMapper);
    }

    @Test
    public void testInsertarPrincipalRequest() {
        GeneralPayload<PrincipalRequestPayload> generalPayload = GeneralPayload.<PrincipalRequestPayload>builder()
                .requestHeader(RequestHeader.builder()
                        .codAliado("1212")
                        .identificacion("1323")
                        .ipOrigen("13213")
                        .numeroSolicitudCredito("121212")
                        .build())
                .requestBody(PrincipalRequestPayload.builder()
                        .codigoAliado("132312")
                        .ipOrigen("121212")
                        .json("{ \"name\":\"John\", \"age\":30, \"car\":null }")
                        .build())
                .build();
        PrincipalRequest principalRequest = PrincipalRequest.builder().build();
        Mockito.when(principalRequestService.insertaPrincipalRequest(Mockito.any())).thenReturn(principalRequest);
        ResponseEntity<ResponsePayLoad> result = principalRequestController.insertaPrincipalRequest(generalPayload);
        Assert.assertNotNull(result);
    }
}