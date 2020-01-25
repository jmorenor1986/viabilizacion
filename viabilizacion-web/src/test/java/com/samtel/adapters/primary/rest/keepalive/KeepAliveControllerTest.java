package com.samtel.adapters.primary.rest.keepalive;

import com.samtel.ports.primary.KeepAliveService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeepAliveControllerTest {

    public static final String MESSAGE_ALIVE = "Hi!!, its alive";
    @Mock
    private KeepAliveService keepAliveService;
    private KeepAliveController keepAliveController;

    @Before
    public void setUp() {
        keepAliveController = new KeepAliveController(keepAliveService);
    }

    @Test
    public void testKeepAliveControllerSuccess() {
        Mockito.when(keepAliveService.getAlive()).thenReturn(MESSAGE_ALIVE);
        String result = keepAliveController.getAlive();
        Assert.assertNotNull(result);
    }
}
