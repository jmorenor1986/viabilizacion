package co.com.santander.core.services;

import co.com.santander.ports.secondary.database.santander.ILogOperationRepository;
import co.com.santander.ports.secondary.database.santander.IServicioRepository;
import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.ports.primary.log.CacheUsrService;
import co.com.santander.ports.primary.log.LogService;
import co.com.santander.core.services.log.impl.LogServiceImpl;
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

	private LogGeneral logGeneral;

	@Mock
	private CacheUsrService cacheUsrService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		map = new ModelMapper();
		logService = new LogServiceImpl(logOperationRepo, map, servicioRepository, cacheUsrService);
		logGeneral = LogGeneral.builder()
			.id(Long.valueOf("1"))
			.fecha(new Date())
			.tipo(FlowOperationEnum.NO_APLICA)
			.traza("Esto es una prueba")
			.usuarioMicro("jsierra")
			.build();
	}
	@Test
	public void testServiceLog() {
		Assert.assertNotNull(logService.insertLogOperation(logGeneral));
		Assert.assertNotNull(logService);
	}
}
