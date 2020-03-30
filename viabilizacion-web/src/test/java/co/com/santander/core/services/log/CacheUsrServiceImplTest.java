package co.com.santander.core.services.log;


import co.com.santander.ports.secondary.accesodatos.CacheUsrService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

@SpringBootTest
public class CacheUsrServiceImplTest {

    private CacheUsrService cacheUsrService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
       // this.cacheUsrService = new CacheUsrServiceImpl(cacheUsrRepository);
    }

    @Test
    public void test() {
        //LogEntity logEntity = LogEntity.builder()
//                .id(Long.valueOf("1"))
//                .fecha(new Date())
//                .httpStatus(HttpStatus.OK)
//                .tipo(FlowOperationEnum.VALIDATE_CITY_REQUEST)
//                .servicio(new ServicioEntity())
//                .build();
//        Mockito.when(cacheUsrRepository.inactiveCacheUsr("{}", "REQUEST")).thenReturn(Integer.valueOf("1"));
//        CacheUsrEntity cacheUsrEntity = CacheUsrEntity.builder()
//                .logs(logEntity)
//                .estado(EstadoEnum.ACTIVO)
//                .paramBusq("{}")
//                .tipo("REQUEST")
//                .build();
//        Mockito.when(cacheUsrRepository.save(cacheUsrEntity)).thenReturn(cacheUsrEntity);
//        CacheUsrEntity cache = this.cacheUsrService.insertLogCacheUsr(logEntity, "{}");
//        Assert.assertNotNull(cache);
    }
}
