package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.entity.LogEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class LogOperacionRepository_IT {

    private LogEntity logEntity;
    @Autowired
    private ILogOperationRepository logOperationRepository;

    @Before
    public void setUp() {
        logEntity = LogEntity.builder()
                .usuarioMicro("john")
                .tipo(FlowOperationEnum.CASO_BIZAGI)
                .traza("traza")
                .fecha(new Date())
                .httpStatus(HttpStatus.ACCEPTED)
                .url("url")
                .build();
    }

    @Test
    public void testSave() {
        LogEntity result = logOperationRepository.save(logEntity);
        Assert.assertEquals(Optional.ofNullable(result.getId()), Optional.of(1L));
    }
}
