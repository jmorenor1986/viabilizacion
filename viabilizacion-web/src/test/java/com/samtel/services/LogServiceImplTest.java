package com.samtel.services;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.samtel.core.repository.ILogOperationRepository;
import com.samtel.domain.log.LogGeneral;
import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.ports.primary.log.LogService;
import com.samtel.services.log.LogServiceImpl;

@SpringBootTest
public class LogServiceImplTest {
	@Mock
	private LogService logService;
	@Mock
	private ModelMapper map;
	@Mock
	private ILogOperationRepository logOperationRepo;

	private LogGeneral logGeneral;
	
	@Before
	public void setUp() {
		map = new ModelMapper();
		logService = new LogServiceImpl(logOperationRepo, map);
		logGeneral = LogGeneral.builder()
			.id(Long.valueOf("1"))
			.fecha(new Date())
			.tipo(FlowOperationEnum.NO_APLICA)
			.traza("Esto es una prueba")
			.usuarioMicro("jsierra")
			.build();
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testServiceLog() {
		Assert.assertNotNull(logService.insertLogOperation(logGeneral));
		Assert.assertNotNull(logService);
	}
}
