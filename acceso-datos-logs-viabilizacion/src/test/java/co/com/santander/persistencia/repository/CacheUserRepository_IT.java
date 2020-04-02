package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.common.EstadoEnum;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
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
public class CacheUserRepository_IT {
    @Autowired
    private ICacheUsrRepository cacheUsrRepository;

    @Test
    public void testInactiveCacheUsr() {
        Integer result = cacheUsrRepository.inactiveCacheUsr("param", "tipo");
        Assert.assertEquals(Optional.of(0), Optional.of(result));
    }

    @Test
    public void testFindByParamBusqAndEstadoAndTipo() {
        Optional<CacheUsrEntity> result = cacheUsrRepository.findLogInCache("param", EstadoEnum.ACTIVO, "tipo", FlowOperationEnum.INVOKE_VIGIA_RESPONSE);
        Assert.assertEquals(Optional.empty(), result);
    }

}
