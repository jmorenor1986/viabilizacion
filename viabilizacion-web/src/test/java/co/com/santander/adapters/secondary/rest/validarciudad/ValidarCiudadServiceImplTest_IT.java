package co.com.santander.adapters.secondary.rest.validarciudad;

import co.com.santander.dto.ciudad.ValidarCiudad;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.ports.secondary.solicitud.ValidarCiudadService;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidarCiudadServiceImplTest_IT {

    @Autowired
    private ValidarCiudadService validarCiudadService;

    WireMockServer wireMockServer = new WireMockServer();

    @Before
    public void setUp() {
        wireMockServer.start();
        configureFor("localhost", 8080);
        stubFor(post(urlEqualTo("/auth/realms/3scale-api/protocol/openid-connect/token")).willReturn(aResponse().withHeader("Content-Type", "application/json").withBodyFile("responseKeyCloak.json")));
    }


    @Test
    public void testCallServiceCiudad() {
        String result = validarCiudadService.validarCodigoCiudad(GeneralPayload.<ValidarCiudad>builder()
                .requestBody(ValidarCiudad.builder().build())
                .requestHeader(RequestHeader.builder().build())
                .build(), 1L);
    }

    @After
    public void after() {
        wireMockServer.stop();
    }


}