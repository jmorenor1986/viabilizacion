package co.com.santander.core.services;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.repository.ILogOperationRepository;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.CacheUsrService;
import co.com.santander.persistencia.service.LogService;
import co.com.santander.persistencia.controller.logservice.payload.LogPayload;
import co.com.santander.persistencia.service.impl.LogServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LogServiceImplTest {
    @Mock
    private LogService logService;
    @Mock
    private ModelMapper map;
    @Mock
    private ILogOperationRepository logOperationRepo;
    @Mock
    private IServicioRepository servicioRepository;

    private LogPayload logPayload;

    @Mock
    private CacheUsrService cacheUsrService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        map = new ModelMapper();
        logService = new LogServiceImpl(logOperationRepo, map, servicioRepository, cacheUsrService);
        logPayload = LogPayload.builder()
                .id(Long.valueOf("1"))
                .fecha(new Date())
                .tipo(FlowOperationEnum.NO_APLICA)
                .traza("Esto es una prueba")
                .usuarioMicro("jsierra")
                .build();
    }
    @Test
    public void testServiceLog() {
        Assert.assertNotNull(logService.insertLogOperation(logPayload));
        Assert.assertNotNull(logService);
    }
}
