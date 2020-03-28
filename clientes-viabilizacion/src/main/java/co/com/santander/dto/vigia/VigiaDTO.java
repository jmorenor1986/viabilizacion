package co.com.santander.dto.vigia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VigiaDTO {
    private String nombre;
    private String porcentaje;
}
