package viabilizacion.test.integration.configuration.builder;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;
import viabilizacion.test.integration.configuration.client.ValidarCiudadClientTest;

@Getter
public class ValidarCiudadControllerFeignClientBuilder {
    private ValidarCiudadClientTest validarCiudadClientTest = consultarCiudad(ValidarCiudadClientTest.class, "http://localhost:5001/validacion/v1/ciudad/");

    private static <T> T consultarCiudad(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri);
    }
}


