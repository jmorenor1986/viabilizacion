package viabilizacion.test.integration.configuration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralPayloadTest<T> {

    private RequestHeaderTest requestHeader;
    private T requestBody;
}
