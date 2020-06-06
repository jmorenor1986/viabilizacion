package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.repository.IServicioRepository;
import co.com.santander.persistencia.service.ServicioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ServicioServiceImplTest {

    @Mock
    private IServicioRepository servicioRepository;
    private ServicioService servicioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servicioService = new ServicioServiceImpl(servicioRepository);
    }

    @Test
    public void testFindServiceByService() {
        Mockito.when(servicioRepository.findByServicio(ServicioEnum.BIZAGI)).thenReturn(Optional.of(ServicioEntity.builder().build()));
        Assert.assertNotNull(servicioService.findServiceByService(ServicioEnum.BIZAGI));
    }
}