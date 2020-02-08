package com.samtel.ports.secondary.solicitud;

import com.samtel.domain.solicitud.RequestDictum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DictumServiceTest_IT {

    @Autowired
    private DictumService dictumService;
    @Mock
    private RequestDictum requestDictum;

    @Test
    public void testConsultarSolicitudDictum() {
        Optional<String> result = dictumService.consultarSolicitudDictum(requestDictum);
        Assert.assertNotNull(result.get());

    }
}
