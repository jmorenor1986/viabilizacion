package co.com.santander.persistencia.service;

import co.com.santander.persistencia.common.EstadoEnum;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.repository.ICacheUsrRepository;
import co.com.santander.persistencia.service.impl.CacheUsrServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class CacheUsrServiceTest {
    @Mock
    private ICacheUsrRepository cacheUsrRepository;

    private CacheUsrService cacheUsrService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cacheUsrService = new CacheUsrServiceImpl(cacheUsrRepository);
    }

    @Test
    public void testInsertLogCacheUsr() {
        LogEntity logEntity = LogEntity.builder()
                .tipo(FlowOperationEnum.CASO_BIZAGI_REQUEST)
                .build();

        CacheUsrEntity cacheUsrEntity = CacheUsrEntity.builder()
                .logs(logEntity)
                .estado(EstadoEnum.ACTIVO)
                .paramBusq("cache")
                .tipo("REQUEST")
                .tipoLog(FlowOperationEnum.CASO_BIZAGI_REQUEST)
                .build();


        Mockito.when(cacheUsrRepository.save(cacheUsrEntity)).thenReturn(CacheUsrEntity.builder().id(Long.valueOf("1")).build());
        CacheUsrEntity result = cacheUsrService.insertLogCacheUsr(logEntity, "cache");
        Assert.assertNotNull(result);
    }

    @Test
    public void testValidityLogUserIsPresent() {
        Mockito.when(cacheUsrRepository.findLogInCache("cache", EstadoEnum.ACTIVO, "RESPONSE", FlowOperationEnum.INVOKE_VIGIA_RESPONSE))
                .thenReturn(Optional.of(CacheUsrEntity.builder()
                        .logs(LogEntity.builder()
                                .fecha(new Date())
                                .build())
                        .build()));
        Optional<String> result = cacheUsrService.validityLogUser("cache", 0L, FlowOperationEnum.INVOKE_VIGIA_RESPONSE);
        Assert.assertNotNull(result);

    }
}
