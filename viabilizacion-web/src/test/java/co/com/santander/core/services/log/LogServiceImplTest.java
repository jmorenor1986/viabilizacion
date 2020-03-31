package co.com.santander.core.services.log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class LogServiceImplTest {

    //private LogServiceImpl logService;
//    @Mock
//    ILogOperationRepository logOperationRepository;
//    @Mock
//    IServicioRepository servicioRepository;
//    @Mock
//    LogServiceImpl logEntity;
//    @Mock
//    CacheUsrService cacheUsrService;
//
//    ModelMapper map;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        map = new ModelMapper();
//        logService = new LogServiceImpl(logOperationRepository, map, servicioRepository, cacheUsrService);
//    }
//
//    @Test
//    public void testInsertaLogRestFailed() {
//        LogPayload logGeneral = LogPayload.builder()
//                .url("http://localhost:5001/validacion/v1/ciudad/")
//                .fecha(new Date())
//                .httpStatus(HttpStatus.CONTINUE)
//                .idRequest(Long.valueOf("1"))
//                .tipo(FlowOperationEnum.VALIDATE_CITY_RESPONSE)
//                .traza("true")
//                .usuarioMicro("jsierra")
//                .build();
//
//        Assert.assertEquals(Boolean.FALSE, logService.insertaLogRest(logGeneral, "aaa"));
//    }
//
//    @Test
//    public void testInsertaLogRestSuccess() {
//        LogPayload logGeneral = LogPayload.builder()
//                .url("http://localhost:5001/validacion/v1/ciudad/")
//                .fecha(new Date())
//                .httpStatus(HttpStatus.CONTINUE)
//                .idRequest(Long.valueOf("1"))
//                .tipo(FlowOperationEnum.VALIDATE_CITY_RESPONSE)
//                .traza("true")
//                .usuarioMicro("jsierra")
//                .build();
//        LogEntity logEntity = map.map(logGeneral, LogEntity.class);
//        logEntity.setId(Long.valueOf(1));
//        ServicioEntity servicioEntity =  ServicioEntity.builder()
//                .servicio(ServicioEnum.VALIDATE_CITY)
//                .descripcion("Servicio Validar Ciudad")
//                .id(Long.valueOf(1))
//                .build();
//        Mockito.when(servicioRepository.findByServicio(ServicioEnum.VALIDATE_CITY)).thenReturn(Optional.of(servicioEntity));
//        Mockito.when(logOperationRepository.save(new LogEntity())).thenReturn(logEntity);
//        Mockito.when(logOperationRepository.save(logEntity)).thenReturn(logEntity);
//        Boolean respuesta = logService.insertaLogRest(logGeneral,"123");
//        Assert.assertEquals(Boolean.TRUE, respuesta );
//    }
}
