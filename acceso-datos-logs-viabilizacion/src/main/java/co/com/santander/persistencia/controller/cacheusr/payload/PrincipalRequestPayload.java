package co.com.santander.persistencia.controller.cacheusr.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalRequestPayload {
    private Long id;
    private String json;
}
