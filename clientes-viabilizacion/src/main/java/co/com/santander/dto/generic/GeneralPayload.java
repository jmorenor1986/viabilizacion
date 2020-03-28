package co.com.santander.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralPayload <T> {

    private RequestHeader requestHeader;
    private T requestBody;
}
