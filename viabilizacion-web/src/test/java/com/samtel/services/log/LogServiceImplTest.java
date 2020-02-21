package com.samtel.services.log;

import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.core.repository.IServicioRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.repository.entity.LogEntity;
import com.samtel.domain.repository.entity.ServicioEntity;
import com.samtel.domain.repository.entity.ServicioEnum;
import com.samtel.ports.primary.log.LogService;
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

    private LogServiceImpl logService;
    @Mock
    ILogOperationRepository logOperationRepository;
    @Mock
    IServicioRepository servicioRepository;
    @Mock
    LogServiceImpl logEntity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        logService = new LogServiceImpl(logOperationRepository, new ModelMapper(), servicioRepository);
    }

    @Test
    public void testInsertaLogRestFailed() {
        LogGeneral logGeneral = LogGeneral.builder()
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .fecha(new Date())
                .httpStatus(HttpStatus.CONTINUE)
                .idRequest("1233")
                .tipo(FlowOperationEnum.VALIDATE_CITY_RESPONSE)
                .traza("true")
                .usuarioMicro("jsierra")
                .build();

        Assert.assertEquals(Boolean.FALSE, logService.insertaLogRest(logGeneral));
    }

    @Test
    public void testInsertaLogRestSuccess() {
        LogGeneral logGeneral = LogGeneral.builder()
                .url("http://localhost:5001/validacion/v1/ciudad/")
                .fecha(new Date())
                .httpStatus(HttpStatus.CONTINUE)
                .idRequest("1233")
                .tipo(FlowOperationEnum.VALIDATE_CITY_RESPONSE)
                .traza("true")
                .usuarioMicro("jsierra")
                .build();
        Mockito.when(servicioRepository.findByServicio(logService.validaServicio(FlowOperationEnum.VALIDATE_CITY_RESPONSE))).thenReturn(Optional.of(new ServicioEntity()));
        Boolean respuesta = logService.insertaLogRest(logGeneral);
        Assert.assertEquals(Boolean.TRUE, respuesta );
    }
}
