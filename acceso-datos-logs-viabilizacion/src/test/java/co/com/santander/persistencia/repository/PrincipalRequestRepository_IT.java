package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.entity.PrincipalRequest;
import org.junit.Assert;
import org.junit.Before;
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
public class PrincipalRequestRepository_IT {
    private PrincipalRequest principalRequest;
    @Autowired
    private IPrincipalRequestRepository principalRequestRepository;

    @Before
    public void setUp() {
        principalRequest = PrincipalRequest.builder()
                .codigoAliado("12345")
                .ipOrigen("127.0.0.1")
                .usuarioAliado("john")
                .json("123")
                .build();
    }

    @Test
    public void testSave() {
        PrincipalRequest result = principalRequestRepository.save(principalRequest);
        Assert.assertEquals(java.util.Optional.ofNullable(result.getId()), Optional.of(1L));
    }
}
