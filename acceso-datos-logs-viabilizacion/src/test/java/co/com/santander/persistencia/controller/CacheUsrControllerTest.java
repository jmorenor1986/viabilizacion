package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.controller.payload.CacheLogPayload;
import co.com.santander.persistencia.controller.payload.ValidateLogUserPayload;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.service.CacheUsrService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
public class CacheUsrControllerTest {

    private CacheUsrController cacheController;

    @Mock
    private CacheUsrService cacheUsrService;

    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cacheController = new CacheUsrController(cacheUsrService, modelMapper);
    }

    @Test
    public void testInsertLogCacheUsr() {
        CacheLogPayload cacheUsrPayload = CacheLogPayload.builder()
                .cache("cache")
                .build();
        GeneralPayload<CacheLogPayload> logPayloadGeneral = new GeneralPayload<>();
        logPayloadGeneral.setRequestBody(cacheUsrPayload);
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(cacheUsrPayload, LogEntity.class)).thenReturn(logEntity);
        Mockito.when(cacheUsrService.insertLogCacheUsr(logEntity, cacheUsrPayload.getCache())).thenReturn(CacheUsrEntity.builder().build());
        ResponseEntity<ResponsePayLoad> result = cacheController.insertLogCacheUsr(logPayloadGeneral);
        Assert.assertNotNull(result);

    }

    @Test
    public void testValidityLogUser() {
        GeneralPayload<ValidateLogUserPayload> generalPayload = new GeneralPayload<>();
        ValidateLogUserPayload validityLogUserPayload = ValidateLogUserPayload.builder()
                .cache("cache")
                .vig(1L)
                .build();
        generalPayload.setRequestBody(validityLogUserPayload);
        Mockito.when(cacheUsrService.validityLogUser(validityLogUserPayload.getCache(), validityLogUserPayload.getVig(), FlowOperationEnum.INVOKE_VIGIA_RESPONSE)).thenReturn(Optional.of("dasdasd"));
        ResponseEntity<ResponsePayLoad> result = cacheController.validateLogUser(generalPayload);
        Assert.assertNotNull(result);
    }


}
