package co.com.santander.persistencia.controller;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.controller.payload.general.GeneralPayload;
import co.com.santander.persistencia.controller.payload.general.ResponsePayLoad;
import co.com.santander.persistencia.entity.ServicioEntity;
import co.com.santander.persistencia.service.ServicioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
public class ServicioControllerTest {
    @Mock
    private ServicioService servicioService;
    private ModelMapper modelMapper;
    private ServicioController servicioController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
        servicioController = new ServicioController(servicioService, modelMapper);
    }

    @Test
    public void testFindServiceByService() {
        GeneralPayload<ServicioEnum> servicio = GeneralPayload.<ServicioEnum>builder()
                .requestBody(ServicioEnum.BIZAGI)
                .build();
        ServicioEntity servicioEntity = ServicioEntity.builder()
                .descripcion("12121")
                .vigencia(1L)
                .servicio(ServicioEnum.BIZAGI)
                .build();

        Mockito.when(servicioService.findServiceByService(servicio.getRequestBody())).thenReturn(Optional.of(servicioEntity));
        ResponseEntity<ResponsePayLoad> result = servicioController.findServiceByService(servicio);
        Assert.assertNotNull(result);
    }
}