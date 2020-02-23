package com.samtel.services;

import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.core.repository.IServicioRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.ports.primary.log.CacheUsrService;
import com.samtel.ports.primary.log.LogService;
import com.samtel.services.log.LogServiceImpl;
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
