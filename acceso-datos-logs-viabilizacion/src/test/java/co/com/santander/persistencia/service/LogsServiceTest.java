package co.com.santander.persistencia.service;

import co.com.santander.persistencia.repository.ILogOperationRepository;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.impl.LogServiceImpl;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogsServiceTest {

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
}
