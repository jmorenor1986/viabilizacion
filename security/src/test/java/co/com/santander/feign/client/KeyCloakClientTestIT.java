package co.com.santander.feign.client;

import co.com.santander.feign.config.KeyCloakConfig;
import co.com.santander.feign.dto.ResponseKeyCloakDTO;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.post;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:application-test.yml"})
public class KeyCloakClientTestIT {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(1234);

    @Autowired
    private KeyCloakClient keyCloakClient;

    @Autowired
    private KeyCloakConfig keyCloakConfig;


    @Before
    public void setUp() {
        wireMockRule.stubFor(post(WireMock.urlPathMatching("/auth/realms/3scale-api/protocol/openid-connect/token"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withBodyFile("responseKeyCloak.json")));
    }

    @Test
    public void testCallClientKeyCloakSuccess() {
        ResponseEntity<ResponseKeyCloakDTO> result = keyCloakClient.getToken(keyCloakConfig);
        Assert.assertNotNull(result);
    }

}