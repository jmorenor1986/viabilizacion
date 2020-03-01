package co.com.santander.adapters.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GeneralPayload <T> {

    private RequestHeader requestHeader;
    private T requestBody;
}
