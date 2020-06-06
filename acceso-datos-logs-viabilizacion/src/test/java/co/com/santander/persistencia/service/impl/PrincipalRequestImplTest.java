package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.entity.PrincipalRequest;
import co.com.santander.persistencia.repository.IPrincipalRequestRepository;
import co.com.santander.persistencia.service.PrincipalRequestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrincipalRequestImplTest {

    @Mock
    private IPrincipalRequestRepository principalRequestRepository;

    private PrincipalRequestService principalRequestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        principalRequestService = new PrincipalRequestImpl(principalRequestRepository);
    }

    @Test
    public void testInsertaPrincipalRequest() {
        PrincipalRequest principalRequest = PrincipalRequest.builder().build();
        Mockito.when(principalRequestRepository.save(Mockito.any())).thenReturn(principalRequest);
        Assert.assertNotNull(principalRequestService.insertaPrincipalRequest(principalRequest));
    }
}