package co.com.santander.utils.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionErrorDto {
    private String mensaje;
    private String url;
    private HttpMethod method;
    private String params;

}
