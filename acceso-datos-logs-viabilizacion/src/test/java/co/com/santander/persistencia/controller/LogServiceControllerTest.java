package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.LogPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.service.LogService;
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
public class LogServiceControllerTest {
    @Mock
    private LogService logService;
    private ModelMapper modelMapper;
    private LogServiceController logServiceController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
        logServiceController = new LogServiceController(logService, modelMapper);
    }

    @Test
    public void testInsertLogOperation() {
        GeneralPayload<LogPayload> payload = GeneralPayload.<LogPayload>builder()
                .requestBody(LogPayload.builder()
                        .traza("ssdfsdfsdf")
                        .build())
                .build();
        Mockito.when(logService.insertLogOperation(payload.getRequestBody())).thenReturn(Boolean.TRUE);
        ResponseEntity<ResponsePayLoad> result = logServiceController.insertLogOperation(payload);
        Assert.assertNotNull(result);
    }

}