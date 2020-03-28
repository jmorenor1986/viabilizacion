package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ServicioRepository_IT {
    @Autowired
    private IServicioRepository servicioRepository;

    @Test
    public void testfindByServicioVALIDATE_CITY() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.VALIDATE_CITY);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioDICTUM() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.DICTUM);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioVIGIA() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.VIGIA);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioRECONOCER() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.RECONOCER);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioUBICA() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.UBICA);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioBIZAGI() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.BIZAGI);
        Assert.assertEquals(result, Optional.empty());
    }

    @Test
    public void testfindByServicioNO_APLICA() {
        Optional<ServicioEntity> result = servicioRepository.findByServicio(ServicioEnum.NO_APLICA);
        Assert.assertEquals(result, Optional.empty());
    }

}
