package co.com.santander.core.domain.solicitud.dictum;

import co.com.santander.adapters.dto.RequestHeader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDictum {
    private RequestHeader requestHeader;
    private RequestBody requestBody;
}
