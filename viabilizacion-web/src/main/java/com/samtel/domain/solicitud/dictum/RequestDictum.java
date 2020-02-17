package com.samtel.domain.solicitud.dictum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDictum {
    private RequestHeader requestHeader;
    private RequestBody requestBody;
}
