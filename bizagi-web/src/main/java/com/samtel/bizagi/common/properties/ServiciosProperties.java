package com.samtel.bizagi.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "servicios")
@Data
public class ServiciosProperties {
    private String uriCrearCaso;
}
