package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.controller.payload.CacheUsrPayload;
import co.com.santander.persistencia.controller.payload.ValidateLogUserPayload;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.service.CacheUsrService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
public class CacheUsrControllerTest {

    private CacheUsrController cacheController;

    @Mock
    private CacheUsrService cacheUsrService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cacheController = new CacheUsrController(cacheUsrService);
    }

    @Test
    public void testInsertLogCacheUsr() {
        CacheUsrPayload cacheUsrPayload = CacheUsrPayload.builder()
                .cache("cache")
                .log(LogEntity.builder().build())
                .build();
        Mockito.when(cacheUsrService.insertLogCacheUsr(cacheUsrPayload.getLog(), cacheUsrPayload.getCache())).thenReturn(CacheUsrEntity.builder().build());
        ResponseEntity<CacheUsrEntity> result = cacheController.insertLogCacheUsr(cacheUsrPayload);
        Assert.assertNotNull(result);

    }

    @Test
    public void testValidityLogUser() {
        ValidateLogUserPayload validityLogUserPayload = ValidateLogUserPayload.builder()
                .cache("cache")
                .vig(1L)
                .build();
        Mockito.when(cacheUsrService.validityLogUser(validityLogUserPayload.getCache(), validityLogUserPayload.getVig())).thenReturn(Optional.of("dasdasd"));
        ResponseEntity<String> result = cacheController.validateLogUser(validityLogUserPayload);
        Assert.assertNotNull(result);
    }


}
