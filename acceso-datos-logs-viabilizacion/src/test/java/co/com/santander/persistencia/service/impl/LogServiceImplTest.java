package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.controller.payload.LogPayload;
import co.com.santander.persistencia.entity.LogEntity;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.repository.ILogOperationRepository;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.CacheUsrService;
import co.com.santander.persistencia.service.LogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class LogServiceImplTest {
    @Mock
    ILogOperationRepository logOperationRepository;
    @Mock
    IServicioRepository servicioRepository;
    @Mock
    ModelMapper modelMapper;
    @Mock
    CacheUsrService cacheUsrService;

    private LogService logService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        logService = new LogServiceImpl(logOperationRepository, modelMapper, servicioRepository, cacheUsrService);
    }

    @Test
    public void testInsertLogOperation() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(LogEntity.builder().build());
        Assert.assertEquals(Boolean.TRUE, logService.insertLogOperation(log));
    }

    @Test
    public void testInsertaLogRestCasoBizagi() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.CASO_BIZAGI)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

    @Test
    public void testInsertaLogRestCasoINVOKE_UBICA() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.INVOKE_UBICA)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

    @Test
    public void testInsertaLogRestCasoINVOKE_RECONOCER() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.INVOKE_RECONOCER)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

    @Test
    public void testInsertaLogRestCasoINVOKE_DICTUM() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.INVOKE_DICTUM)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

    @Test
    public void testInsertaLogRestCasoINVOKE_VIGIA() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.INVOKE_VIGIA)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

    @Test
    public void testInsertaLogRestCasoVALIDATE_CITY() {
        LogPayload log = LogPayload.builder()
                .idRequest(1L)
                .traza("13123123123")
                .tipo(FlowOperationEnum.VALIDATE_CITY)
                .build();
        LogEntity logEntity = LogEntity.builder().build();
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(logEntity);
        Mockito.when(servicioRepository.findByServicio(Mockito.any())).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Mockito.when(logOperationRepository.save(Mockito.any())).thenReturn(logEntity);
        Assert.assertNotNull(logService.insertaLogRest(log, "121212"));
    }

}