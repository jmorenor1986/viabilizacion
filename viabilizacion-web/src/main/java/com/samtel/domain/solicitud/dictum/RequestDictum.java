package com.samtel.domain.solicitud.dictum;

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
