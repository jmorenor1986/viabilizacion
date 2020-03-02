package co.com.santander.adapters.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GeneralPayload <T> {

    private RequestHeader requestHeader;
    private T requestBody;
}
