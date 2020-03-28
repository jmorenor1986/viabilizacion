package co.com.santander.dto.dictum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametrosDTO {
    private String tipo;
    private String nombre;
    private String valor;
}
