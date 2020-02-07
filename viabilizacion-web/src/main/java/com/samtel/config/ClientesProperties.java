package com.samtel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "servicios")
@Data
public class ClientesProperties {
    private String uriValidarCiudad;
}
