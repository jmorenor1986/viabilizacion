package co.com.santander.config;

import feign.Client;
import feign.Logger;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.XSlf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import feign.codec.Encoder;
import org.springframework.util.ResourceUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


@XSlf4j
@Configuration
@EnableFeignClients(basePackages = "co.com.santander.clients")
//@PropertySources({ @PropertySource("classpath:application-services.properties") })
public class ConfigFeign {

    public ConfigFeign() {
        log.entry(ConfigFeign.class.getName());
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }

    @Bean
    public Client feignClient() {
        Client trustSSLSockets = new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
        return trustSSLSockets;
    }

    private SSLSocketFactory getSSLSocketFactory() {
        try {
            TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            };
            String allPassword = "S3rv1c10sPr3m13r";
            SSLContext sslContext = SSLContextBuilder
                    .create()
                    // .loadKeyMaterial(ResourceUtils.getFile("classpath:keystore.p12"), allPassword.toCharArray(), allPassword.toCharArray())
                    .loadKeyMaterial(ResourceUtils.getFile("classpath:jks/ServiciosPremeirCredit.jks"), allPassword.toCharArray(), allPassword.toCharArray())
                    .loadTrustMaterial(ResourceUtils.getFile("classpath:jks/ServiciosPremeirCredit.jks"), allPassword.toCharArray())
                    .build();
            return sslContext.getSocketFactory();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}