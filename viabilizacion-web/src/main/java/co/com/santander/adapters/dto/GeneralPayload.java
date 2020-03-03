package co.com.santander.adapters.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralPayload <T> {

    private RequestHeader requestHeader;
    private T requestBody;
}
