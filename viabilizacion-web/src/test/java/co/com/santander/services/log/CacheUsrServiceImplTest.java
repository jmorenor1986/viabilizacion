package co.com.santander.services.log;

import co.com.santander.core.repository.ICacheUsrRepository;
import co.com.santander.domain.repository.entity.*;
import co.com.santander.ports.primary.log.CacheUsrService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

@SpringBootTest
public class CacheUsrServiceImplTest {

    private CacheUsrService cacheUsrService;
    @Mock
    private ICacheUsrRepository cacheUsrRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.cacheUsrService = new CacheUsrServiceImpl(cacheUsrRepository);
    }

    @Test
    public void test(){
        LogEntity logEntity = LogEntity.builder()
                .id(Long.valueOf("1"))
                .fecha(new Date())
                .httpStatus(HttpStatus.OK)
                .idRequest("123")
                .tipo(FlowOperationEnum.VALIDATE_CITY_REQUEST)
                .servicio(new ServicioEntity())
                .build();
        Mockito.when(cacheUsrRepository.inactiveCacheUsr("{}", "REQUEST")).thenReturn(Integer.valueOf("1"));
        CacheUsrEntity cacheUsrEntity = CacheUsrEntity.builder()
                .logs(logEntity)
                .estado(EstadoEnum.ACTIVO)
                .paramBusq("{}")
                .tipo("REQUEST")
                .build();
        Mockito.when(cacheUsrRepository.save(cacheUsrEntity)).thenReturn(cacheUsrEntity);
        CacheUsrEntity cache =  this.cacheUsrService.insertLogCacheUsr(logEntity, "{}");
        Assert.assertNotNull(cache);
    }
}
