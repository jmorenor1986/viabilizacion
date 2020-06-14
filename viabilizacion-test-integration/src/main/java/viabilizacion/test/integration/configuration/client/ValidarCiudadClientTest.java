package viabilizacion.test.integration.configuration.client;

import feign.Headers;
import feign.RequestLine;
import viabilizacion.test.integration.configuration.dto.GeneralPayloadTest;
import viabilizacion.test.integration.configuration.dto.ResponseDtoTest;
import viabilizacion.test.integration.configuration.dto.ValidarCiudadTest;

public interface ValidarCiudadClientTest {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    ResponseDtoTest consultarCiudad(GeneralPayloadTest<ValidarCiudadTest> request);
}
